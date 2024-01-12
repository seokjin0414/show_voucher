function loadBundles(lang) {
    jQuery.i18n.properties({
        name: 'messages',
        path: '/properties/',
        mode: 'map',
        language: lang,
        callback: function () {
            // updateExamples();
        }
    });
}

function cleanError() {
    $('.input-item').removeClass('is-error');
    $('.input-item').find('.error-text').html("");
}

function showError(id, msg) {
    $('#' + id).find('.error-text').text(msg);
    $('#' + id).addClass('is-error');
}

function showLoginError(id, msg) {
    $('#' + id).text("*"+msg);
    $('#' + id).addClass('is-error');
}

function cleanError2(id) {
    $("#"+id).removeClass('is-error');
    $("#"+id).find('.error-text').html('');
}

function showError2(id, msg) {
    $('#' + id).addClass('is-error');
	$('#' + id).find(".error-text").html(msg);
}

function i18n(msg) {
    var args = "\"" + msg + "\"";
    for (var i = 1; i < arguments.length; i++) {
        args += ", \"" + arguments[i] + "\"";
    }
    try {
        if (parent != this) {
            return eval("parent.i18n(" + args + ")");
        }
        return eval("jQuery.i18n.prop(" + args + ")");
    } catch (e) {
        return msg;
    }
}

function createCookie(name, value, minutes) {
    if (minutes) {
        var date = new Date();
        date.setTime(date.getTime() + (minutes * 60 * 1000));
        var expires = "; expires=" + date.toGMTString();
    } else {
        var expires = "";
    }
    document.cookie = name + "=" + value + expires + "; path=/";
}

function setCookie(cookieName, value, exHours) {
    var exdate = new Date();
    // exdate.setDate(exdate.getDate() + exdays);
    exdate.setHours(exdate.getHours() + exHours);
    var cookieValue = escape(value) + ((exHours == null) ? "" : "; path=/; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;

    // console.log(cookieName,"=",cookieValue);
}

function deleteCookie(cookieName) {
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; path=/; expires=" + expireDate.toGMTString();
}

function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if (start != -1) {
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if (end == -1) end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}

var urlParam = function (name) {
    var results = new RegExp('[\?&]' + name + '=([^&#]*)')
        .exec(window.location.search);

    return (results !== null) ? results[1] || 0 : '';
}

function formatNumber(num) {
    if (num == null || num == 'null') {
        num = "0";
    }
    num = num + "";
    return num.replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
}

var alertMsg = function (msg) {
    alert(msg);
};

var alerti18 = function (msg) {
    alert(i18n(msg));
};

var toast = function (msg) {
    $.toast({
        heading: 'alerm',
        text: msg,
        position: 'mid-center',
        stack: false
    })
}

var confirmMsg = function (msg, fn) {
    return confirm(msg);
}

var copyToClipboard = function(str) {

    var varUA = navigator.userAgent.toLowerCase();
    var el = document.createElement('textarea');
    el.value = str;
    document.body.appendChild(el);
    if ( (varUA.indexOf("iphone")>-1||varUA.indexOf("ipad")>-1||varUA.indexOf("ipod")>-1)) {

        var editable = el.contentEditable;
        var readOnly = el.readOnly;
        el.contentEditable = 'true';
        el.readOnly = 'false';
        var range = document.createRange();
        range.selectNodeContents(el);
        var sel = window.getSelection();
        sel.removeAllRanges();
        sel.addRange(range);
        el.setSelectionRange(0, 999999);
        el.contentEditable = editable;
        el.readOnly = readOnly;

    } else {
        el.select();
    }
    document.execCommand('copy');
    document.body.removeChild(el);
    alerti18('클립보드로 복사되었습니다.');
};

String.prototype.string = function (len) { var s = '', i = 0; while (i++ < len) { s += this; } return s; };
String.prototype.zf = function (len) { return "0".string(len - this.length) + this; };
Number.prototype.zf = function (len) { return this.toString().zf(len); };

$(document).on("keyup", "input:text[numberOnly]", function () {
    $(this).val($(this).val().replace(/[^0-9]/gi, ""));
});

function null2void(str) {
    if (str) return str;
    else return "";
}

function set_year(obj, start_year, end_year) {

    var idx = end_year;

    for (; idx >= start_year; idx--) {
        $(obj).append("<option value='" + idx + "'>" + idx + "</option>");
    }
}

function makeRandom() {
    var RandVal = Math.floor(Math.random() * (45)) + 1;
    return RandVal;
}

function comma(x, isTrim) {
    return numeral(x).format('0,0');
}

function decimalComma(x, fix) {
    if (fix == 0) {
        return numeral(x).format('0,0');
    }
    var zero = "";
    for (i = 0; i < fix; i++) {
        zero += '0';
    }
    return numeral(x).format('0,0.' + zero);
}

var pageConfig = function (data, pageSize) {
    var pages = 5;

    var total = data.total;
    var offset = data.offset;
    var totalPage = parseInt(total / pageSize);
    if (total % pageSize > 0) {
        totalPage += 1;
    }
    var first = 1;
    var last = totalPage;
    var startPage = parseInt(offset / pages) * pages;
    if ((offset % pages) > 0) {
        startPage += 1;
    }
    if (startPage == 0) {
        startPage = 1;
    }

    var endPage = startPage - 1 + pages;
    if (endPage > totalPage) {
        endPage = totalPage;
    }
    if (startPage > endPage) {
        startPage = endPage;
    }
    var pages = new Array();
    console.info('startPage', startPage)
    console.info('endPage', endPage)
    for (i = startPage; i <= endPage; i++) {
        pages.push(i);
    }

    var pre = offset - 1;
    if (pre == 0) {
        pre = 1;
    }
    var next = offset + 1;
    if (next > totalPage) {
        next = totalPage;
    }

    return {
        first: first
        , last: last
        , pre: pre
        , next: next
        , pages: pages
    };

};

var DateDiff = {
    inHours: function (d1, d2) {
        var t2 = d2.getTime();
        var t1 = d1.getTime();

        return parseInt((t2 - t1) / (3600 * 1000));
    },

    inDays: function (d1, d2) {
        var t2 = d2.getTime();
        var t1 = d1.getTime();

        return parseInt((t2 - t1) / (24 * 3600 * 1000));
    },

    inWeeks: function (d1, d2) {
        var t2 = d2.getTime();
        var t1 = d1.getTime();

        return parseInt((t2 - t1) / (24 * 3600 * 1000 * 7));
    },

    inMonths: function (d1, d2) {
        var d1Y = d1.getFullYear();
        var d2Y = d2.getFullYear();
        var d1M = d1.getMonth();
        var d2M = d2.getMonth();

        return (d2M + 12 * d2Y) - (d1M + 12 * d1Y);
    },

    inYears: function (d1, d2) {
        return d2.getFullYear() - d1.getFullYear();
    }
}

function isEmpty(str) {
    return (!str || /^\s*$/.test(str));
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

function textLengthOverCut(txt, len, lastLen) {
    if (len == "" || len == null) {
        len = 10;
    }

    if (txt.length > len) {
        txt = txt.substr(0, len) + '...' + txt.substr(txt.length - lastLen, txt.length);
    }

    return txt;
}

function loadMask(isShow, msg, _backImgPath, _backOptionStyle, _msgOptionStyle) {
    if (isShow) {
        var msgOnOff = true;
        if (msg == "" || msg == null)
            msgOnOff = false;

        if ($("#ajaxScreen").length == 0) {
            var backImgPath = "/asset/img/rolling.svg";
            if (_backImgPath != null) {
                backImgPath = _backImgPath
            }
            var backFixedStyle = {
                "position": "fixed",
                "width": "100%",
                "height": "100%"
            }
            var msgFixedStyle = {
                "position": "absolute"
            }
            var backOptionStyle = {
                "opacity": "0.5",
                "z-index": "100000"
            }
            if (_backOptionStyle != null) {
                backOptionStyle = _backOptionStyle;
            }
            var msgOptionStyle = {
                "color": "white",
                "width": "250px",
                "text-align": "center",
                "z-index": "100001"
            }
            if (_msgOptionStyle != null) {
                msgOptionStyle = _msgOptionStyle;
            }
            $('body').prepend("<div id='ajaxScreen'></div>");
            $("#ajaxScreen").append("<div id='ajaxBack'></div>");
            $("#ajaxBack").css(backFixedStyle).css(backOptionStyle);
            if (msgOnOff) {
                $("#ajaxScreen").append("<span id='ajaxMsg' style=''>" + msg + "</span>");
                $("#ajaxMsg").css(msgFixedStyle).css(msgOptionStyle);
            }
            msgWidth = $("#ajaxMsg").width();
            msgHeight = $("#ajaxMsg").height();
            msgLeft = msgWidth / 2;
            msgTop = (msgHeight / 2) - 40;

            $("#ajaxMsg").css({
                "left": "calc(50% - " + msgLeft + "px)",
                "top": "calc(50% - " + msgTop + "px)"
            });
            $('<img/>').attr('src', backImgPath).on('load', function () {
                $(this).remove();
                $("#ajaxBack").css({"background": "url('" + backImgPath + "') no-repeat black 50% 50%"});
            }).on('error', function () {
                $(this).remove();
                $("#ajaxBack").css({"background-color": "black"});
                $("#ajaxBack").append('<?xml version="1.0" encoding="utf-8"?><svg width="30px" height="30px" style="position:absolute; top:calc(50% - 15px); left:calc(50% - 15px);" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="xMidYMid" class="uil-ring"><rect x="0" y="0" width="100" height="100" fill="none" class="bk"></rect><circle cx="50" cy="50" r="40" stroke-dasharray="163.36281798666926 87.9645943005142" stroke="#cec9c9" fill="none" stroke-width="20"><animateTransform attributeName="transform" type="rotate" values="0 50 50;180 50 50;360 50 50;" keyTimes="0;0.5;1" dur="1s" repeatCount="indefinite" begin="0s"></animateTransform></circle></svg>');

            });
        }
    } else {
        $("#ajaxScreen").remove();
    }
}

function inputNumberFormat(obj) {
    if (typeof obj !== "object") {
        return comma(uncomma(String(obj)))
    }
    obj.value = comma(uncomma(obj.value));
}

function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}
function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}
