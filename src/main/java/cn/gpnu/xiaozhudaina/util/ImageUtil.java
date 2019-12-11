package cn.gpnu.xiaozhudaina.util;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    //获取编译后的Java文件的根目录 即在classes目录   便于在以后得到水印图片
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();

    /**
     * 获取该用户校园卡存储的路径
     * @param userId
     * @return
     */
    private static String getUserImageAddr(Integer userId){
        return PathUtil.getUserImagePath(userId);
    }

    /**
     * 创建目标路径所涉及到的目录，即/home/work/xiangze/xxx.jpg,
     * 那么 home work xiangze 这三个文件夹都得自动创建
     *
     * @param userImageAddr
     */
    private static void makeDirPath(String userImageAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + userImageAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     *
     * @return
     */
    private static String getRandomFileName() {
        //获取随机五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    /**
     * 获取输入文件流的扩展名  在用输出流写出时当后缀名
     *
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String generateThumbnail(MultipartFile file,Integer userId){
        String userImageAddr = getUserImageAddr(userId);
        makeDirPath(userImageAddr);
        String randomFileName = getRandomFileName();
        String fileExtension = getFileExtension(file.getOriginalFilename());
        //根据userId生成的存储用户图片的文件夹 + 随机名 + 后缀
        String fileDest = userImageAddr + randomFileName + fileExtension;
        //加上 电脑存储图片基本路径   用于写入
        File dest = new File(PathUtil.getImgBasePath() + fileDest);
        try{
            //TODO 可以打水印
            /*
                Thumbnails.of(thumbnail.getImage()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
            */
            Thumbnails.of(file.getInputStream()).toFile(dest);
        }catch (IOException e){
            e.printStackTrace();
        }
        return fileDest;
    }



}
