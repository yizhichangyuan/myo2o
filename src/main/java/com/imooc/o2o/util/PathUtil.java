package com.imooc.o2o.util;

/**
 * 项目图片的根路径，项目图片的子路径
 */
public class PathUtil {

    /**
     * 根据系统选择用户上传图片存储的根路径
     *
     * @return
     */
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";

        // 关于图片为什么放置在其他路径而不是resources下
        // 因为应用部署的时候，之后重新部署应用项目会重新回到部署前的状态
        // 在之前部署过程中用户上传的新增的图片就会被删除
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/projectdev/image";
        } else {
            basePath = "/Users/yizhichangyuan/image";
        }

        // 路径分隔符替换为系统分隔符
        basePath = basePath.replace("/", System.getProperty("file.separator"));
        return basePath;
    }

    /**
     * 根据上传的店铺id选择该店铺图片放置根路径
     *
     * @param shopId
     * @return
     */
    public static String getShopImgPath(long shopId) {
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", System.getProperty("file.separator"));
    }

    public static String getProductSimpleImgPath(long shopId, long productId) {
        String productPath = "/upload/item/shop/" + shopId + "/" + productId + "/";
        return productPath.replaceAll("/", System.getProperty("file.separator"));
    }

    public static String getProductDetailImgPath(long shopId, long productId) {
        String productPath = "/upload/item/shop/" + shopId + "/" + productId + "/detail/";
        return productPath.replaceAll("/", System.getProperty("file.separator"));
    }
}
