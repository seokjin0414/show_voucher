var winFixST = 0;
var zindex = 1000;

$(function () {
  touchEvent();
  inputPassword();
  selectEvent();
  //expansionPanel();
  numberMix();
  numberInsert();
  removeNumber();
  clearNumber();
  //slickEvent();
  //toggleEvent();
  tabEvent();
});

function touchEvent() {
  $(".btn").each(function () {
    $(this)
        .on("touchstart", function () {
          $(this).off("mouseenter").off("mouseleave").addClass("hover");
        })
        .on("touchend", function () {
          $(this).off("mouseenter").off("mouseleave").removeClass("hover");
        });
    $(this)
        .on("mouseenter", function () {
          $(this).addClass("hover");
        })
        .on("mouseleave", function () {
          $(this).removeClass("hover");
        });
  });
}

function inputPassword() {
  $(".input-pw").each(function () {
    var inp = $(this);
    inp.find(".btn-show").on("click", function () {
      if (!inp.hasClass("on")) {
        inp.addClass("on");
      } else {
        inp.removeClass("on");
      }
    });
    inp.find('input[type="password"]').on("keyup", function () {
      var inpVal = $(this).val();
      inp.find('input[type="text"]').val(inpVal);
    });
    inp.find('input[type="text"]').on("keyup", function () {
      var inpVal = $(this).val();
      inp.find('input[type="password"]').val(inpVal);
    });
  });
}

function dialogOpen(target) {
  zindex = zindex + 1;
  $("body").addClass("scroll-fixed");
  $(target).stop().fadeIn(200);
  $(target).addClass("on");
  $(target).css("z-index", zindex);
  winFixST = $("body").scrollTop();
}

function dialogOpenPop(target) {
  zindex = zindex + 1;
  $("body").addClass("scroll-fixed");
  $(target).stop().fadeIn(200);
  $(target).addClass("on");
  $(target).css("z-index", zindex);
  winFixST = $("body").scrollTop();
}

function dialogClose(target) {
  $("body").removeClass("scroll-fixed");
  $(window).scrollTop(winFixST);
  $(target).stop().fadeOut(200);
  $(target).removeClass("on");
}

function dialogClosePop(target) {
  $("body").removeClass("scroll-fixed");
  $(window).scrollTop(winFixST);
  $(target).stop().fadeOut(200);
  $(target).removeClass("on");
}

function selectEvent() {
  $(".select__area").each(function () {
    const target = $(this).find("a");
    target.on("click", function () {
      target.removeClass("on");
      $(this).addClass("on");
    });
  });
}

function expansionPanel() {
  $(".expansion__panel").each(function () {
    const panel = $(this);
    const header = panel.find(".expansion__panel--header");
    const contents = panel.find(".expansion__panel--contents");
    header.on("click", function () {
      if (!panel.hasClass("on")) {
        panel.addClass("on");
        $(".expansion__panel--contents").hide();
        contents.show();
      } else {
        panel.removeClass("on");
        contents.hide();
      }
    });
  });
}

function numberMix() {
  $(".number--keypad__number").each(function () {
    const pad = $(this).find("button");
    for (var i = 0; i < pad.length; i++) {
      const target = Math.floor(Math.random() * pad.length - 1) + 1;
      const target2 = Math.floor(Math.random() * pad.length - 1) + 1;
      pad.eq(target).before(pad.eq(target2));
    }
  });
}

function numberInsert() {
  const pad = $(".number--keypad__number button");
  pad.on("click", function () {
    const inpV = $(this).closest(".number--keypad").find(" .password-code").val();
    const val = $(this).text();
    if (inpV.length < 6) {
      $(this)
          .closest(".number--keypad")
          .find(" .password-code")
          .val(inpV + val);
    }
  });
}

function removeNumber() {
  $(".number--keypad__control .btn-remove").on("click", function () {
    const inpV = $(this).closest(".number--keypad").find(" .password-code").val();
    const del = inpV.substring(0, inpV.length - 1);
    $(this).closest(".number--keypad").find(".password-code").val(del);
  });
}

function clearNumber() {
  $(".number--keypad__control .btn-clear").on("click", function () {
    $(this).closest(".number--keypad").find(" .password-code").val("");
  });
}

function slickEvent() {
  $(".slick__slide").slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    // autoplay: true,
    // autoplaySpeed: 5000,
    dots: false,
    arrows: false,
    centerMode: true,
    centerPadding: "10px",
  });
}

function toggleEvent() {
  $(".toggle-wrap").each(function () {
    const wrap = $(this),
        btn = $(this).find(".btn-toggle");
    btn.on("click", function () {
      if (!wrap.hasClass("on")) {
        wrap.addClass("on");
      } else {
        wrap.removeClass("on");
      }
    });
  });
}

function tabEvent() {
  $(".tab .btn-tab").on("click", function () {
    const wrap = $(this).closest(".tab-wrap"),
        idx = $(this).index();
    wrap.find(".btn-tab").removeClass("on");
    $(this).addClass("on");
    wrap.find(".tab-content").removeClass("on");
    wrap.find(".tab-content").eq(idx).addClass("on");
  });
}

function layerOpen(target){
    zindex = zindex+1;
    winFixST = $(window).scrollTop();
    $('body').addClass('scroll-fixed');
    $(window).scrollTop(winFixST);
    $(target).stop().fadeIn(300, function(){
        $(target).addClass('on');
    });
    $(target).find('.contents').stop().animate({'bottom': 0},300);
    $(target).css('z-index', zindex);
}

function layerClose(target){
    $('body').removeClass('scroll-fixed');
    $(window).scrollTop(winFixST);
    $(target).stop().fadeOut(300);
    $(target).removeClass('on');
    $(target).find('.contents').stop().animate({'bottom': '-100%'},300);
    zindex = zindex-1;
}




