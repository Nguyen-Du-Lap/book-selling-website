const form_login = document.getElementById('form_login');
const email = document.getElementById('email');
const password = document.getElementById('password');
 
// form_login.addEventListener('submit', (e) => {
//     e.preventDefault();
//     checkInputs();
// });

// handle onchane 

function emailOnChange(value) {
    if(value === '') {
      setError(email, 'Vui lòng nhập vào email');
    } else if(!isEmail(value)) {
        setError(email, 'Email không hợp lệ');
    } else {
        setSuccess(email);
    }
}

function passwordOnChange(value) {
    if(value === '') {
        setError(password, 'Vui lòng nhập vào mật khẩu');
    } else if(value.length < 8) {
        setError(password, 'Mật khẩu phải có ít nhất 8 kí tự');
    } else {
        setSuccess(password);   
    }
}

function setError(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
    formControl.className = 'input error';
}
function setSuccess(input) {
    const formControl = input.parentElement;
    formControl.className = 'input success';
}


  // handle when submit
function checkInputs() {
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();

    if(emailValue === '') {
        setErrorFor(email, 'Vui lòng nhập vào email');
    } else if(!isEmail(emailValue)) {
        setErrorFor(email, 'Email không hợp lệ');
    } else {
        setSuccessFor(email);
    }

    if(passwordValue === '') {
        setErrorFor(password, 'Vui lòng nhập vào mật khẩu');
    } else if(passwordValue.length < 8) {
        setErrorFor(password, 'Mật khẩu phải có ít nhất 8 kí tự');
    } else {
        setSuccessFor(password);
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
function isEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

