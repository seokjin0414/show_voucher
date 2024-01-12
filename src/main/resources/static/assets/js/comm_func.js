function makeQrCode(id_name, width, height, qr_data) {
    $("#"+id_name).empty();
    var qrcode = new QRCode(document.getElementById(id_name), {
        width: 100,
        height: 100
    });
    qrcode.makeCode(qr_data);

    return qrcode;
}

function numberFormat(number, decimal) {
    const option = {
        maximumFractionDigits: decimal
    };

    return parseInt(number).toLocaleString('ko-KR', option);
}

function addrFormat(addr) {
    return addr.substr(0, 6) + "..." + addr.substr(addr.length - 4, addr.length);
}

function uf_print_coin_balance(balance , pad_len) {
	if(balance=='0E-8'){
		balance=0;
	}
	if (pad_len == null || pad_len == 'undefine') {
		pad_len = 0;
	}


	if(pad_len !="") {}
	else pad_len = 0;

	var dealPrice = balance+'';
	if (dealPrice.indexOf(".") < 0) {
		dealPrice = dealPrice+'.0';
	}
	var bal_arr = dealPrice.split(".");

	var bal_1 = bal_arr[0];
	var bal_2 = bal_arr[1];

	if(bal_2) {}
	else bal_2 = "";

	if(bal_2.length > pad_len) {
		bal_2 = bal_2.substring(0,pad_len);
	} else {
		bal_2 = rpad(bal_2, pad_len, "0")
	}
	if(pad_len==0){
		return formatNumber(bal_1)
	}else {
		var bal_text = formatNumber(bal_1) + "." + bal_2;
		return bal_text;
	}
}

function lpad(str, padLen, padStr) {
    if (padStr.length > padLen) {
        return str;
    }
    str += "";
    padStr += "";
    while (str.length < padLen)
        str = padStr + str;
    str = str.length >= padLen ? str.substring(0, padLen) : str;
    return str;
}


function rpad(str, padLen, padStr) {
    if (padStr.length > padLen) {
        return str + "";
    }
    str += "";
    padStr += "";
    while (str.length < padLen)
        str += padStr;
    str = str.length >= padLen ? str.substring(0, padLen) : str;
    return str;
}