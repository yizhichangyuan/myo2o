$(function () {
    addUrl();

    function addUrl() {
        var shopId = getQueryString("shopId");
        $("#shopinfo").attr("href", "/o2o/shopadmin/shopoperation?shopId=" + shopId);
    }
});