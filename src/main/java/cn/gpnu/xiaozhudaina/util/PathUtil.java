package cn.gpnu.xiaozhudaina.util;

public class PathUtil {
    //得到当前系统的间隔符
    private static String seperator = System.getProperty("file.separator");

    /**
     * 基于不同的系统  用不同路径下存图片
     * @return
     */
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath;
        if (os.toUpperCase().startsWith("WIN")){
            basePath = "D:/project/image/";
        }else {
            basePath = "/home/project/image/";
        }
        basePath = basePath.replace("/",seperator);
        return basePath;
        //todo
    }

    /**
     *
     * @param userId
     * @return
     */
    public static String getUserImagePath(Integer userId){
        String imagePath = "upload/card/" + userId + "/";
        imagePath = imagePath.replace("/",seperator);
        return imagePath;
    }
}
