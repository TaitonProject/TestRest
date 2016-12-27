/**
 * Открыть модаль "Тест"
 **/
$(".test-popup-btn").on("click", function () {
    var popup = $("#modal-test");
    popup.addClass("open");
});

/**
 * Кнопка скрыть модали
 **/
$(".modal-container .shade, .close-modal").on("click", function (e) {
    if (e.target === e.currentTarget) {
        $(".modal-container.open").removeClass("open").addClass("close");
    }
});
$(".modal-container .shade").on('transitionend webkitTransitionEnd oTransitionEnd otransitionend MSTransitionEnd',
    function () {
        var modal = $(".modal-container");
        if (modal.hasClass("close")) {
            modal.removeClass("close")
        }
    });

/**
 * Центрирование модалей
 */
var centerPopup = function() {
    var mainDiv = $(".modal-container.open .popup-content");
    var mainHeight = parseInt((window.innerHeight-mainDiv.height())/2);
    if (Math.max(document.documentElement.clientHeight, window.innerHeight || 0) > (mainDiv.height()+50)) {
        mainDiv.css({"margin-top": mainHeight});
    } else {
        mainDiv.css({"margin": "30px auto"});
    }
};
$(".center-popup-btn").on("click", centerPopup);
$(window).on("resize", centerPopup);
$(window).trigger("resize");
