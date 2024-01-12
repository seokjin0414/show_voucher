$(function () {

    $('a[href=""], a[href="#"]').each(function(){
        $(this).attr('href','javascript:void(0);')
    });

    $.fn.getNotice = function (pageSize, page, idx) {
        
        var offset = 0;
        if(pageSize =="")
        {
            pageSize = 20;
        }
        var next_yn = true;

        if(page == "layer")
        {
            $(".layer").html($(".tmp-notice").html());
            $(".layer").addClass("layer-notice").addClass("type2");
        }
        var param = {
            "offset" : offset,
            "pageSize" : pageSize,
            "idx" : idx
        }
        var url = BOARD_URL + "/notice/list";
        postJson(url, param, function (json) {
            var innerHtml = "";
            if (json.code == '200') {
                var class_val = "";

                $.each(json.data.notice_list,function(i,item){
	
                    if(page == "layer") {
                        if(idx == "") {

                            //class_val = (idx == item.noticeIdx) ? "accordion-collapse collapse show" : "accordion-collapse collapse";

                            innerHtml += " <div class=\"accordion-item\">\n" +
                                "                    <h2 class=\"accordion-header\" style=\"margin-bottom:0px;\">\n" +
                                "                        <button class=\"accordion-button collapsed\" type=\"button\" onclick=\"$.fn.getNotice('', 'layer','"+item.noticeIdx+"');\" data-bs-target=\"#accordion0" + i + "\">\n" +
                                "                            " + item.noticeTitle + "\n" +
                                "                        </button>\n" +
                                "                    </h2>\n" +
                                "                    <div id=\"accordion0" + i + "\" class=\"accordion-collapse collapse\" data-bs-parent=\"#accordionExample1\">\n" +
                                "                        <div class=\"accordion-body\">\n" +
                                "                            " + item.noticeContents + "\n" +
                                "                        </div>\n" +
                                "                    </div>\n" +
                                "                </div>";
                        }else{
                            innerHtml += "<h1>\n" +
                                "                 " + item.noticeTitle + "\n" +
                                "            </h1>\n" +
                                "            <div class=\"blog-header-info mt-2 mb-2\">\n" +
                                "                <div>\n" +
                                "                </div>\n" +
                                "                <div>\n" +
                                "                    " + item.regDtm + "\n" +
                                "                </div>\n" +
                                "            </div>\n" +
                                "            <div class=\"lead\">\n" +
                                "                " + item.noticeContents + "\n" +
                                "            </div>";
                        }
                    }else{
                        innerHtml += "<li data-volume='"+item.noticeIdx+"'>\n" +
                            "                    <a href=\"javascript:void(0);\" class=\"item\">\n" +
                            "                        <div class=\"icon-box bg-warning\">\n" +
                            "                            <ion-icon name=\"chatbubble-outline\" role=\"img\" class=\"ion ion-md-text\" style=\"padding-left: 5px\" aria-label=\"chatbubble outline\"></ion-icon>\n" +
                            "                        </div>\n" +
                            "                        <div class=\"in\">\n" +
                            "                            <div>\n" +
                            "                                <div class=\"mb-05\"><strong>"+item.noticeTitle+"</strong></div>\n" +
                            "                                <div class=\"text-xsmall\">"+item.regDtm+"</div>\n" +
                            "                            </div>\n" +
                            "                        </div>\n" +
                            "                    </a>\n" +
                            "                </li>";
                    }
                });

				

                if(page == "layer") {
	
                    if(idx == "") {
                        $(".layer #accordionExample1").html(innerHtml);
                    }else{
                        $(".layer .notice_view_area").html(innerHtml);
                    }
                    $(".layer .accordion-body img").width("100%");
                }else{
                    if(json.data.notice_list.length > 0) {
                        $(".notice_area").show();
                        $(".notice_list").html(innerHtml);
                    }else{
                        $(".notice_area").hide();
                    }
                }
            }
        });
        if(page == "layer") {
            layerOpen('.layer');
        }
    }
});