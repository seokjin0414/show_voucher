var errorHandler = function (jqXHR, textStatus, errorThrow) {
    if (jqXHR.status == 500) {
        alerti18(errorThrow);
    } else if (jqXHR.status == 404) {
        alert("Page not found!");
    } else {
        console.error(textStatus);
        console.error(errorThrow);
    }
};

var jsonCall = function (url, paramMap, type, callback, loadyn) {

    $('.loading').remove()
    if (!loadyn) loadyn = "Y";
    //<!-- 로딩 -->
    if (loadyn == "Y") {
        var loading_txt = "<div class='loading' style='display:none;opacity:50%'>"
            + "<div class='spin loading-icon'></div>"
            + "</div>";
        $("body").append(loading_txt);

        $(".loading").show();
    }

    var ctrlRef = $.ajax({
        url: url,
        type: type,
        contentType: "application/json",
        data: JSON.stringify(paramMap),
        dataType: "json",
        timeout: 90000,
        error: errorHandler,
        success: function (data, textStatus, jqXHR) {
            if (data.code == '401') {
                go_login();
                return;
            }
            if (data.code == '403') {
                go_login();
                return;
            }
            callback(data);
        },
        complete: function (jqXHR, textStatus) {
            $(".loading").remove();

        }
    });
    return ctrlRef;
};

var postJson = function (url, paramMap, callback, loadyn) {
    // if (paramMap) {
    //     paramMap.csrfKey = $("#csrfKey").val();
    // }

    return jsonCall(url, paramMap, 'POST', callback, loadyn);
}

var getJson = function (url, paramMap, callback, loadyn) {
    return jsonCall(url, paramMap, 'GET', callback, loadyn);
}

var paramCall = function (url, paramMap, type, callback, loadyn) {
    $('.loading').remove()
    if (!loadyn) loadyn = "Y";
    //<!-- 로딩 -->
    if (loadyn == "Y") {
        var loading_txt = "<div class='loading' style='display:none;opacity:50%'>"
            + "<div class='spin loading-icon'></div>"
            + "</div>";
        $("body").append(loading_txt);

        $(".loading").show();
    }

    var ctrlRef = $.ajax({
        url: url,
        type: type,
        data: $.param(paramMap),
        error: errorHandler,
        success: function (data, textStatus, jqXHR) {
            if (data.code == '401') {
                go_login();
                return;
            }
            if (data.code == '403') {
                go_login();
                return;
                return;
                return;
            }
            callback(data);
        },
        complete: function (jqXHR, textStatus) {
            if (loadyn == "Y") $(".loading").hide();
        }
    });
    return ctrlRef;
};

var paramJson = function (type, url, paramMap, callback, loadyn) {
    return paramCall(url, paramMap, type, callback, loadyn);
};