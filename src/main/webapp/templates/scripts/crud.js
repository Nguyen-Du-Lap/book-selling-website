function deleteProduct(id) {
    var option = confirm("Bạn có muốn xóa sản phẩm!");
    if(option === true) {
        window.location.href='deleteProduct?id='+id;
    }
}

function showEmpEdit() {
    window.location.href='findByProduct?id='+id;
}