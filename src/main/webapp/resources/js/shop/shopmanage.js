$(function () {
    addUrl();

    function addUrl(shopId) {
        var shopId = getQueryString("shopId");
        $.ajax({
            url: "/o2o/shopadmin/getshopmanagementinfo?shopId=" + shopId,
            type: 'get',
            dataType: 'json',
            success: function (data) {
                if (data.redirect) {
                    window.location.href = data.url;
                } else {
                    if (data.shopId != undefined || data.shopId != null) {
                        shopId = data.shopId;
                        console.log(shopId);
                        $("#shop-info").attr("href", "/o2o/shopadmin/shopoperation?shopId=" + shopId);
                    }
                }
            }
        });
    }
});