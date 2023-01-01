const form = document.getElementById('form');
const email = document.getElementById('acc_email');
const fname = document.getElementById('acc_fname');
const lname = document.getElementById('acc_lname');
const phoneNumber = document.getElementById('acc_phoneNumber');

form.addEventListener('submit', (e) => {
    e.preventDefault();
    checkInputs();
});

function checkInputs() {
    const emailValue = email.value.trim();
    const fnameValue = fname.value.trim();
    const lnameValue = lname.value.trim();
    const phoneNumberValue = phoneNumber.value.trim();

    if(emailValue === '') {
        setErrorFor(email, 'Vui lòng nhập email của bạn');
    } else if(!isEmail(emailValue)) {
        setErrorFor(email, 'Email không hợp lệ');
    } else {
        setSuccessFor(email);
    }

    if(fnameValue === '') {
        setErrorFor(fname, 'Vui lòng nhập họ của bạn');
    } else {
        setSuccessFor(fname);
    }
    if(lnameValue === '') {
        setErrorFor(lname, 'Vui lòng nhập tên của bạn');
    } else {
        setSuccessFor(lname);
    }
    if(phoneNumberValue === '') {
        setErrorFor(phoneNumber, 'Vui lòng nhập số điện thoại của bạn');
    } else if(!isPhoneNumber(phoneNumberValue)) {
        setErrorFor(phoneNumber, 'Số điện thoại không hợp lệ')
    } else {
        setSuccessFor(phoneNumber);
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
function isPhoneNumber(phoneNumber) {
    return /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(phoneNumber);
}
var citis = document.getElementById("city");
var districts = document.getElementById("district");
var wards = document.getElementById("ward");
var Parameter = {
    url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
    method: "GET",
    responseType: "application/json",
};
var promise = axios(Parameter);
promise.then(function (result) {
    renderCity(result.data);
});

function renderCity(data) {
    for (const x of data) {
        citis.options[citis.options.length] = new Option(x.Name, x.Id);
    }
    citis.onchange = function () {
        district.length = 1;
        ward.length = 1;
        if(this.value != ""){
            const result = data.filter(n => n.Id === this.value);

            for (const k of result[0].Districts) {
                district.options[district.options.length] = new Option(k.Name, k.Id);
            }
        }
    };
    district.onchange = function () {
        ward.length = 1;
        const dataCity = data.filter((n) => n.Id === citis.value);
        if (this.value != "") {
            const dataWards = dataCity[0].Districts.filter(n => n.Id === this.value)[0].Wards;

            for (const w of dataWards) {
                wards.options[wards.options.length] = new Option(w.Name, w.Id);
            }
        }
    };
}
