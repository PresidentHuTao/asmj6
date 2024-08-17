const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function ($scope, $http) {
    alert("AngularJS intialized");
//quản lý giỏ hàng
    $scope.cart = {
        items: [],
        //thêm sp vào giỏ
        //mỗi khi tải lại trang rồi gọi hàm add thì mới làm mới localstorage chứ chỉ mỗi
        //tải lại thì chưa
        add(id) {
            alert(id)
            //kt xem sp đã chọn có trong giỏ hay chưa, có thì +1 slg còn chưa thì tạo mới
            var item = this.items.find(item => item.id == id)
            if (item) {
                //qty là slg của 1 sp trong giỏ
                item.qty++;
                this.saveToLocalStorage();
            } else {
                //gọi ra restcontroller để tìm sp được trả về
                //vì restcontroller mới trả về đối tượng để cho $http lấy ra được
                $http.get(`/rest/product/${id}`).then(resp => {
                    resp.data.qty = 1
                    //thêm sp đó vào localstorage
                    this.items.push(resp.data)
                    this.saveToLocalStorage()
                })
            }
        },
        //xóa 1 sp khỏi giỏ
        remove(id) {
            //tìm ra index để xóa
            var index = this.items.findIndex(item => item.id == id)
            //splice sẽ xóa 1 phần tử bắt đầu từ vị trí index
            this.items.splice(index, 1)
            //xóa xong thì lưu lại thay đổi
            this.saveToLocalStorage()
        },
        //xóa sạch sp khỏi giỏ
        clear() {
            //clear thì chỉ cần đặt items là 1 mảng rỗng rồi lưu lại cho nhanh
            this.items = []
            this.saveToLocalStorage()
        },
        //tính thành tiền 1 sp
        amt_of(item) {
        },
        //tính tổng slg mặt hàng trong giỏ
        get count() {
            return this.items
                //map mỗi item tương ứng 1 đơn vị qty rồi cộng dồn với khởi điểm 0
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0)
        },
        //tổng thành tiền các mặt hàng trong giỏ
        get amount() {
            return this.items
                //tương tự nhưng map mỗi item với đơn giá
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0)
        },
        //lưu giỏ hàng vào local storage
        saveToLocalStorage() {
            //chuyển 1 đối tượng trong js thành json
            var json = JSON.stringify(angular.copy(this.items))
            //đường dẫn lưu vào localStorage: f12/application/localstorage/localhost
            localStorage.setItem("cart", json)
        },
        //đọc giỏ hàng từ local storage
        //json lúc này nằm trong local storage của trang web nên trừ khi xóa đi bằng ko
        //vẫn lưu đó dù build lại hay refresh
        loadFromLocalStorage() {
            //lấy ra item cart từ ls => json
            var json = localStorage.getItem("cart")
            //chuyển json thành đối tượng js để có cart mà hiển thị
            //ko tìm thấy thì trả về giá trị khởi điểm là 0 (xem hàm count, amount)
            this.items = json ? JSON.parse(json) : []
        },
    }
    $scope.cart.loadFromLocalStorage()
    $scope.order = {
        createDate: new Date(),
        address: "",
        //test thì tạm thời dùng cách fix cứng còn sau này dùng được security
        //thí mới hiển thị bằng tên người dùng đăng nhập vào sau (ALFKI là th user đầu tiên trong db)
        account: {username: "ALFKI"},
        //duyệt qua từng sp trong giỏ hàng rồi gửi toàn bộ lên server
        get orderDetail() {
            return $scope.cart.items.map(item => {
                return {
                    //trường id thì đã được đặt là tự động tăng nên khỏi cần khai
                    product: {id: item.id},
                    price: item.price,
                    quantity: item.qty
                }
            })
        },
        purchase() {
            var order = angular.copy(this)
            //thực hiện đặt hàng
            $http.post("/rest/order", order).then(resp => {
                alert("đặt hàng thành công!")
                $scope.cart.clear()
                location.href = "/order/detail/" + resp.data.id
            }).catch(error => {
                alert("đặt hàng lỗi")
                console.log(error)
            })

        }
    }
})