const form = document.getElementById('form');
const password = document.getElementById('acc_oldPass');
const password2 = document.getElementById('acc_newPass');
const password3 = document.getElementById('acc_confirmPass');

//form.addEventListener('submit', (e) => {
//    e.preventDefault();
//    checkInputs();
//});

function checkInputs() {
    const passwordValue = password.value.trim();
    const password2Value = password2.value.trim();
    const password3Value = password3.value.trim();

    if(passwordValue === '') {
        setErrorFor(password, 'Vui lòng nhập mật khẩu của bạn');
    } else if(passwordValue.length < 8) {
        setErrorFor(password, 'Mật khẩu phải có ít nhất 8 kí tự');
    } else {
        setSuccessFor(password);
    }

    if(password2Value === '') {
        setErrorFor(password2, 'Vui lòng nhập mật khẩu mới');
    } else if (password2Value.length < 8) {
        setErrorFor(password2, "Mật khẩu phải có ít nhất 8 kí tự");
    } else {
        setSuccessFor(password2);
    }
    if(password3Value === '') {
        setErrorFor(password3, 'Vui lòng nhập lại mật khẩu');
    } else if (password3Value !== password2Value) {
        setErrorFor(password3, "Mật khẩu không khớp");
    } else {
        setSuccessFor(password3);
    }

}
function setErrorFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
    formControl.className = 'input error';
}
function setSuccessFor(input) {
    const formControl = input.parentElement;
    formControl.className = 'input success';
}

