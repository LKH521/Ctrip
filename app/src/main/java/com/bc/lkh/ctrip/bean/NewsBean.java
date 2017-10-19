package com.bc.lkh.ctrip.bean;

import java.util.List;

/**
 * Created by wangye on 2017/8/2.
 */

public class NewsBean {


  /**
   * reason : 成功的返回
   * result : {"stat":"1","data":[{"uniquekey":"14e3b8acbce73ad2167373fb34adbd96","title":"林志玲录节目素颜曝光 皮肤虽发黄但五官精致","date":"2017-08-02 07:37","category":"头条","author_name":"新浪娱乐","url":"http://mini.eastday.com/mobile/170802073727564.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802073727_0aee2797dbb21dfa41001c564d312c6e_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170802/20170802073727_e1bcd93cebc4709bae3dd230d6adc8c8_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170802/20170802073727_bb33da679aff621e07d9aa0d7a51b770_5_mwpm_03200403.jpg"},{"uniquekey":"e558012cb27079d3e6bbe6842c329cb3","title":"世界豪华房车之最：高12米里面有29个液晶电视","date":"2017-08-02 07:37","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170802073723740.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170802/20170802073723_e542d691c1d5fa1caa53a453d7305098_7_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170802/20170802073723_e542d691c1d5fa1caa53a453d7305098_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170802/20170802073723_e542d691c1d5fa1caa53a453d7305098_3_mwpm_03200403.jpg"},{"uniquekey":"de5921ef323160d917fad35a99c02ccb","title":"诈骗30亿 印尼遣返153中国诈骗犯","date":"2017-08-02 07:37","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170802073723529.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170802/20170802073723_021fc4585a077a9b9bf863cdc172301a_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170802/20170802073723_021fc4585a077a9b9bf863cdc172301a_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170802/20170802073723_021fc4585a077a9b9bf863cdc172301a_3_mwpm_03200403.jpg"},{"uniquekey":"9a2149784b62e736c59666849a5e50e1","title":"澎湃新闻对话万里挑一空军飞行员：冲上云霄的光荣与艰辛","date":"2017-08-02 07:36","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170802073657157.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170802/20170802073657_d4e81b352dabd13fb98c46e2b1111a92_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170802/20170802073657_d4e81b352dabd13fb98c46e2b1111a92_2_mwpm_03200403.jpg"},{"uniquekey":"6c358e8976d1693830a6b6e3bff2fa4c","title":"泰国前总理英拉否认大米收购案所有指控","date":"2017-08-02 07:24","category":"头条","author_name":"新华社","url":"http://mini.eastday.com/mobile/170802072451444.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170802/20170802072451_0a8ecce4d1ca5c6b03d2acdc5c8d9e9c_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170802/20170802072451_4e3c9f83f8e94da4e6ff7c1ae66cb835_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170802/20170802072451_90b445d55d43e9f78d0c4065ad519a6c_2_mwpm_03200403.jpg"},{"uniquekey":"f43afc7aa2de8c66fa93f800f2e1b379","title":"外国员工就职华为、阿里：竟然这样称赞中国企业","date":"2017-08-02 07:12","category":"头条","author_name":"http://net.zol.com.cn/649/6496650.html","url":"http://mini.eastday.com/mobile/170802071208738.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170802/20170802071208_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20170802/20170802071208_d41d8cd98f00b204e9800998ecf8427e_2_mwpm_03200403.jpg"},{"uniquekey":"7e6f734802efc14a664120823ae89f6b","title":"太壕！刘强东一句话员工感动哭：改变了人生","date":"2017-08-02 06:58","category":"头条","author_name":"快科技","url":"http://mini.eastday.com/mobile/170802065808688.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170802/20170802065808_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170802/20170802065808_d41d8cd98f00b204e9800998ecf8427e_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170802/20170802065808_d41d8cd98f00b204e9800998ecf8427e_2_mwpm_03200403.jpg"},{"uniquekey":"c10426a658c9523be15d6b8b71b9d93f","title":"\u201c中国军队独一无二！\u201d 外国人花式点赞中国阅兵","date":"2017-08-02 06:57","category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/170802065733920.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170802/20170802065733_f03604267150286b2d8a753a63dbb7ab_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170802/20170802065733_f03604267150286b2d8a753a63dbb7ab_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170802/20170802065733_f03604267150286b2d8a753a63dbb7ab_1_mwpm_03200403.jpg"},{"uniquekey":"5eedf7d576bcb5efd9b8758cebdd5013","title":"三年过去了，赵丽颖的恋情藏不住了，网友纷纷祝福！","date":"2017-08-02 06:36","category":"头条","author_name":"赵梦杨","url":"http://mini.eastday.com/mobile/170802063647423.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802063647_d41d8cd98f00b204e9800998ecf8427e_9_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170802/20170802063647_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170802/20170802063647_d41d8cd98f00b204e9800998ecf8427e_11_mwpm_03200403.jpg"},{"uniquekey":"ea0b74d795d125622a8fa639a633a5e6","title":"献礼建军90周年 长沙橘子洲上演焰火《军魂》","date":"2017-08-02 06:24","category":"头条","author_name":"中国网","url":"http://mini.eastday.com/mobile/170802062419517.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802062419_1373cb32aefaaf0b465c3c4bd3ff34d0_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170802/20170802062419_4b3e4f1c3a0f8de4abe4685c51a92357_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170802/20170802062419_fd181d5e4c01ea9e5d039f805e454f05_2_mwpm_03200403.jpg"},{"uniquekey":"d782e2cec1bdae4839a208217a8b6e91","title":"邛海开海 \"捕鱼王\"捕到18.2公斤大鱼","date":"2017-08-02 06:24","category":"头条","author_name":"中国青年报","url":"http://mini.eastday.com/mobile/170802062404874.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802062404_046ad29f553080316e344179ddd0ac4d_1_mwpm_03200403.jpg"},{"uniquekey":"c838ac2900eababafea81adf8d7d31a7","title":"郑州：\u201c爱心零钱箱\u201d测试市民诚信 没人多拿多占","date":"2017-08-02 06:22","category":"头条","author_name":"郑州晚报","url":"http://mini.eastday.com/mobile/170802062258548.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170802/20170802062258_a7633408cbbfa635704615f4b2a4a284_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170802/20170802062258_a7633408cbbfa635704615f4b2a4a284_1_mwpm_03200403.jpg"},{"uniquekey":"cbe1644aa3ce005d41870aa35f5697b6","title":"为治\u201c低头族\u201d，美国城市下狠手：过马路玩手机，罚款！","date":"2017-08-02 06:22","category":"头条","author_name":"每日经济新闻","url":"http://mini.eastday.com/mobile/170802062232441.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170802/20170802062232_2fe5194b278469d3ccfedc879ba235ea_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170802/20170802062232_2fe5194b278469d3ccfedc879ba235ea_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170802/20170802062232_2fe5194b278469d3ccfedc879ba235ea_1_mwpm_03200403.jpg"},{"uniquekey":"1dc9b65d925199bf03f5044d0afa6bc2","title":"为地球的明天\u201c备份\u201d生物 ","date":"2017-08-02 06:17","category":"头条","author_name":"新浪新闻","url":"http://mini.eastday.com/mobile/170802061717602.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170802/20170802061717_75a1991074919367ae8479fd9b4cc5d5_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170802/20170802061717_75a1991074919367ae8479fd9b4cc5d5_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170802/20170802061717_75a1991074919367ae8479fd9b4cc5d5_1_mwpm_03200403.jpg"},{"uniquekey":"f430d3584cfa21e41d0a896a8e57dea1","title":"少年弑母案背后问题重重 该如何拯救悲剧中的孩子","date":"2017-08-02 06:06","category":"头条","author_name":"中国青年报","url":"http://mini.eastday.com/mobile/170802060630714.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170802/20170802060630_5708c6de4c94af5dfae8274de0bff270_1_mwpm_03200403.jpg"},{"uniquekey":"1cddda9c2175340a6f9bdffe6d7eea51","title":"揭 \" 入侵家庭摄像头 \" 产业链 : 隐私画面或正全球直播","date":"2017-08-02 06:01","category":"头条","author_name":"中国青年网","url":"http://mini.eastday.com/mobile/170802060150128.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802060150_3360e3f820c31b2ab9d4903a48b8e046_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170802/20170802060150_3360e3f820c31b2ab9d4903a48b8e046_6_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170802/20170802060150_3360e3f820c31b2ab9d4903a48b8e046_4_mwpm_03200403.jpg"},{"uniquekey":"252da7706d7c6638905677233036377f","title":"煮好一颗鸡蛋比你想象的要难多了","date":"2017-08-02 05:56","category":"头条","author_name":"山兔君","url":"http://mini.eastday.com/mobile/170802055625361.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170802/20170802055625_16a08e1e38d107c029c02e1a4ba53cb0_8_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20170802/20170802055625_16a08e1e38d107c029c02e1a4ba53cb0_10_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20170802/20170802055625_16a08e1e38d107c029c02e1a4ba53cb0_5_mwpm_03200403.jpg"},{"uniquekey":"9f70d500938b1dd8c0fd3541a2248936","title":"为什么清兵胸前的字不相同？\u201c勇\u201d是什么？\u201c兵\u201d是什么？","date":"2017-08-02 05:54","category":"头条","author_name":"新奇的历史事","url":"http://mini.eastday.com/mobile/170802055458438.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170802/20170802055458_85f5bef814cd504ae52c3f9b072d9875_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170802/20170802055458_85f5bef814cd504ae52c3f9b072d9875_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170802/20170802055458_85f5bef814cd504ae52c3f9b072d9875_2_mwpm_03200403.jpg"},{"uniquekey":"6e30e428009ebde267c1f1226cc8646a","title":"15个副省级城市 步入服务经济时代 广州、深圳高速领跑","date":"2017-08-02 05:49","category":"头条","author_name":"21世纪经济报道","url":"http://mini.eastday.com/mobile/170802054950854.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170802/20170802054950_bcb0299ff3d2784b6d329d733d0ab8a2_1_mwpm_03200403.jpg"},{"uniquekey":"d9e06b0f6e3db1d9e95f87161e615552","title":"晨起黄金10分钟，让你多活10年！赶紧学起来","date":"2017-08-02 05:20","category":"头条","author_name":"广东医疗","url":"http://mini.eastday.com/mobile/170802052041927.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170802/20170802052041_96f6c13073620805cb5a23bdd85df5f7_5_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170802/20170802052041_96f6c13073620805cb5a23bdd85df5f7_9_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170802/20170802052041_96f6c13073620805cb5a23bdd85df5f7_6_mwpm_03200403.jpg"},{"uniquekey":"edca17fe74f21c0ace646b28daf5ab50","title":"内地男星人气榜：鹿晗第五，马天宇第三，第一名无可争议","date":"2017-08-02 05:15","category":"头条","author_name":"娱圈八妹","url":"http://mini.eastday.com/mobile/170802051513398.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802051513_ce65edaccb30f6ae8f4f0180d6fc5625_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170802/20170802051513_ce65edaccb30f6ae8f4f0180d6fc5625_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170802/20170802051513_ce65edaccb30f6ae8f4f0180d6fc5625_5_mwpm_03200403.jpg"},{"uniquekey":"ee7b036825483a5e053109c3d8d339ee","title":"油价调整最新消息：距离汽油、柴油价格上调 仅剩三天！涨幅多少呢？","date":"2017-08-02 05:10","category":"头条","author_name":"油价汽油柴油查询","url":"http://mini.eastday.com/mobile/170802051005979.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802051005_d6c6eb6089fb154df349cb1d097ce135_1_mwpm_03200403.jpg"},{"uniquekey":"1837009a56155bb37d5370521d6ab486","title":"一张升级版上海文体设施布局图绘就 迎新一轮文化空间发展","date":"2017-08-02 05:04","category":"头条","author_name":"解放日报","url":"http://mini.eastday.com/mobile/170802050409305.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170802/20170802050409_d68e60fa04a89cc3757156885427933b_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20170802/20170802050409_d68e60fa04a89cc3757156885427933b_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20170802/20170802050409_d68e60fa04a89cc3757156885427933b_3_mwpm_03200403.jpg"},{"uniquekey":"5a85f13a0a195bdf879f7049c535e41d","title":"一旦股票遇到这五大卖出信号, 立马清仓逃命, 别犹豫","date":"2017-08-02 05:00","category":"头条","author_name":"每日财经微评","url":"http://mini.eastday.com/mobile/170802050047666.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170802/20170802050047_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170802/20170802050047_d41d8cd98f00b204e9800998ecf8427e_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170802/20170802050047_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg"},{"uniquekey":"014b99a373663a6ce85377e0a445a1b3","title":"一个胖女人，曾被张艺谋相中，离婚后找了小15岁老公","date":"2017-08-02 04:54","category":"头条","author_name":"娱三哥","url":"http://mini.eastday.com/mobile/170802045443101.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170802/20170802045443_27ca6f336464df5ebbaf1a692b6bfb05_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170802/20170802045443_27ca6f336464df5ebbaf1a692b6bfb05_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170802/20170802045443_27ca6f336464df5ebbaf1a692b6bfb05_1_mwpm_03200403.jpg"},{"uniquekey":"64588dd15a700c3f8c0c5d995e968ae5","title":"自己做菜没时间，快手菜帮你快速吃上佳肴！","date":"2017-08-02 04:53","category":"头条","author_name":"搞笑美食创意","url":"http://mini.eastday.com/mobile/170802045358391.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170802/20170802045358_dc8c209c9f8f8b610b98b15ccb1ba85b_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170802/20170802045358_dc8c209c9f8f8b610b98b15ccb1ba85b_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170802/20170802045358_dc8c209c9f8f8b610b98b15ccb1ba85b_3_mwpm_03200403.jpg"},{"uniquekey":"6f9dc38f34af6a4651c03ec548bbbc39","title":"小市场关了 便民店来了","date":"2017-08-02 04:53","category":"头条","author_name":"中国青年报","url":"http://mini.eastday.com/mobile/170802045331138.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170802/20170802045331_497182c59f877d0ce33c3d013e4885ca_1_mwpm_03200403.jpg"},{"uniquekey":"a74aa8ed12a5a7fa2b5d2430dfb367c9","title":"这两个个北洋军阀玩转日本人，一个不办事，一个骗回甲午赔款！","date":"2017-08-02 04:49","category":"头条","author_name":"历史尘封","url":"http://mini.eastday.com/mobile/170802044952914.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170802/20170802044952_b6de2aa57e3c621047a7bc06e9307dc6_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170802/20170802044952_b6de2aa57e3c621047a7bc06e9307dc6_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170802/20170802044952_b6de2aa57e3c621047a7bc06e9307dc6_5_mwpm_03200403.jpg"},{"uniquekey":"2b267c0b1b659569fd42838fbd9bd63f","title":"美国牛肉卷土重来，\u201c狼来了\u201d吗？","date":"2017-08-02 04:45","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170802044555927.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170802/20170802044555_7eb2e4b114e9cd57182d11d34fe8a144_1_mwpm_03200403.jpg"},{"uniquekey":"1d29ea9210e468076aa0d438706af143","title":"巴基斯坦国民议会选出新任政府总理","date":"2017-08-02 04:41","category":"头条","author_name":"人民日报","url":"http://mini.eastday.com/mobile/170802044142249.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170802/20170802044142_9fe0860dbdf8b305d3675b5047cb6094_1_mwpm_03200403.jpg"}]}
   * error_code : 0
   */

  private String reason;
  private ResultBean result;
  private int error_code;

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public ResultBean getResult() {
    return result;
  }

  public void setResult(ResultBean result) {
    this.result = result;
  }

  public int getError_code() {
    return error_code;
  }

  public void setError_code(int error_code) {
    this.error_code = error_code;
  }

  public static class ResultBean {

    /**
     * stat : 1
     * data : [{"uniquekey":"14e3b8acbce73ad2167373fb34adbd96","title":"林志玲录节目素颜曝光 皮肤虽发黄但五官精致","date":"2017-08-02 07:37","category":"头条","author_name":"新浪娱乐","url":"http://mini.eastday.com/mobile/170802073727564.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802073727_0aee2797dbb21dfa41001c564d312c6e_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170802/20170802073727_e1bcd93cebc4709bae3dd230d6adc8c8_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170802/20170802073727_bb33da679aff621e07d9aa0d7a51b770_5_mwpm_03200403.jpg"},{"uniquekey":"e558012cb27079d3e6bbe6842c329cb3","title":"世界豪华房车之最：高12米里面有29个液晶电视","date":"2017-08-02 07:37","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170802073723740.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170802/20170802073723_e542d691c1d5fa1caa53a453d7305098_7_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170802/20170802073723_e542d691c1d5fa1caa53a453d7305098_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170802/20170802073723_e542d691c1d5fa1caa53a453d7305098_3_mwpm_03200403.jpg"},{"uniquekey":"de5921ef323160d917fad35a99c02ccb","title":"诈骗30亿 印尼遣返153中国诈骗犯","date":"2017-08-02 07:37","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170802073723529.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170802/20170802073723_021fc4585a077a9b9bf863cdc172301a_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170802/20170802073723_021fc4585a077a9b9bf863cdc172301a_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170802/20170802073723_021fc4585a077a9b9bf863cdc172301a_3_mwpm_03200403.jpg"},{"uniquekey":"9a2149784b62e736c59666849a5e50e1","title":"澎湃新闻对话万里挑一空军飞行员：冲上云霄的光荣与艰辛","date":"2017-08-02 07:36","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170802073657157.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170802/20170802073657_d4e81b352dabd13fb98c46e2b1111a92_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170802/20170802073657_d4e81b352dabd13fb98c46e2b1111a92_2_mwpm_03200403.jpg"},{"uniquekey":"6c358e8976d1693830a6b6e3bff2fa4c","title":"泰国前总理英拉否认大米收购案所有指控","date":"2017-08-02 07:24","category":"头条","author_name":"新华社","url":"http://mini.eastday.com/mobile/170802072451444.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170802/20170802072451_0a8ecce4d1ca5c6b03d2acdc5c8d9e9c_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170802/20170802072451_4e3c9f83f8e94da4e6ff7c1ae66cb835_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170802/20170802072451_90b445d55d43e9f78d0c4065ad519a6c_2_mwpm_03200403.jpg"},{"uniquekey":"f43afc7aa2de8c66fa93f800f2e1b379","title":"外国员工就职华为、阿里：竟然这样称赞中国企业","date":"2017-08-02 07:12","category":"头条","author_name":"http://net.zol.com.cn/649/6496650.html","url":"http://mini.eastday.com/mobile/170802071208738.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170802/20170802071208_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20170802/20170802071208_d41d8cd98f00b204e9800998ecf8427e_2_mwpm_03200403.jpg"},{"uniquekey":"7e6f734802efc14a664120823ae89f6b","title":"太壕！刘强东一句话员工感动哭：改变了人生","date":"2017-08-02 06:58","category":"头条","author_name":"快科技","url":"http://mini.eastday.com/mobile/170802065808688.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170802/20170802065808_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170802/20170802065808_d41d8cd98f00b204e9800998ecf8427e_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170802/20170802065808_d41d8cd98f00b204e9800998ecf8427e_2_mwpm_03200403.jpg"},{"uniquekey":"c10426a658c9523be15d6b8b71b9d93f","title":"\u201c中国军队独一无二！\u201d 外国人花式点赞中国阅兵","date":"2017-08-02 06:57","category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/170802065733920.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170802/20170802065733_f03604267150286b2d8a753a63dbb7ab_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170802/20170802065733_f03604267150286b2d8a753a63dbb7ab_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170802/20170802065733_f03604267150286b2d8a753a63dbb7ab_1_mwpm_03200403.jpg"},{"uniquekey":"5eedf7d576bcb5efd9b8758cebdd5013","title":"三年过去了，赵丽颖的恋情藏不住了，网友纷纷祝福！","date":"2017-08-02 06:36","category":"头条","author_name":"赵梦杨","url":"http://mini.eastday.com/mobile/170802063647423.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802063647_d41d8cd98f00b204e9800998ecf8427e_9_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170802/20170802063647_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170802/20170802063647_d41d8cd98f00b204e9800998ecf8427e_11_mwpm_03200403.jpg"},{"uniquekey":"ea0b74d795d125622a8fa639a633a5e6","title":"献礼建军90周年 长沙橘子洲上演焰火《军魂》","date":"2017-08-02 06:24","category":"头条","author_name":"中国网","url":"http://mini.eastday.com/mobile/170802062419517.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802062419_1373cb32aefaaf0b465c3c4bd3ff34d0_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170802/20170802062419_4b3e4f1c3a0f8de4abe4685c51a92357_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170802/20170802062419_fd181d5e4c01ea9e5d039f805e454f05_2_mwpm_03200403.jpg"},{"uniquekey":"d782e2cec1bdae4839a208217a8b6e91","title":"邛海开海 \"捕鱼王\"捕到18.2公斤大鱼","date":"2017-08-02 06:24","category":"头条","author_name":"中国青年报","url":"http://mini.eastday.com/mobile/170802062404874.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802062404_046ad29f553080316e344179ddd0ac4d_1_mwpm_03200403.jpg"},{"uniquekey":"c838ac2900eababafea81adf8d7d31a7","title":"郑州：\u201c爱心零钱箱\u201d测试市民诚信 没人多拿多占","date":"2017-08-02 06:22","category":"头条","author_name":"郑州晚报","url":"http://mini.eastday.com/mobile/170802062258548.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170802/20170802062258_a7633408cbbfa635704615f4b2a4a284_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170802/20170802062258_a7633408cbbfa635704615f4b2a4a284_1_mwpm_03200403.jpg"},{"uniquekey":"cbe1644aa3ce005d41870aa35f5697b6","title":"为治\u201c低头族\u201d，美国城市下狠手：过马路玩手机，罚款！","date":"2017-08-02 06:22","category":"头条","author_name":"每日经济新闻","url":"http://mini.eastday.com/mobile/170802062232441.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170802/20170802062232_2fe5194b278469d3ccfedc879ba235ea_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170802/20170802062232_2fe5194b278469d3ccfedc879ba235ea_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170802/20170802062232_2fe5194b278469d3ccfedc879ba235ea_1_mwpm_03200403.jpg"},{"uniquekey":"1dc9b65d925199bf03f5044d0afa6bc2","title":"为地球的明天\u201c备份\u201d生物 ","date":"2017-08-02 06:17","category":"头条","author_name":"新浪新闻","url":"http://mini.eastday.com/mobile/170802061717602.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170802/20170802061717_75a1991074919367ae8479fd9b4cc5d5_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170802/20170802061717_75a1991074919367ae8479fd9b4cc5d5_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170802/20170802061717_75a1991074919367ae8479fd9b4cc5d5_1_mwpm_03200403.jpg"},{"uniquekey":"f430d3584cfa21e41d0a896a8e57dea1","title":"少年弑母案背后问题重重 该如何拯救悲剧中的孩子","date":"2017-08-02 06:06","category":"头条","author_name":"中国青年报","url":"http://mini.eastday.com/mobile/170802060630714.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170802/20170802060630_5708c6de4c94af5dfae8274de0bff270_1_mwpm_03200403.jpg"},{"uniquekey":"1cddda9c2175340a6f9bdffe6d7eea51","title":"揭 \" 入侵家庭摄像头 \" 产业链 : 隐私画面或正全球直播","date":"2017-08-02 06:01","category":"头条","author_name":"中国青年网","url":"http://mini.eastday.com/mobile/170802060150128.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802060150_3360e3f820c31b2ab9d4903a48b8e046_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170802/20170802060150_3360e3f820c31b2ab9d4903a48b8e046_6_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170802/20170802060150_3360e3f820c31b2ab9d4903a48b8e046_4_mwpm_03200403.jpg"},{"uniquekey":"252da7706d7c6638905677233036377f","title":"煮好一颗鸡蛋比你想象的要难多了","date":"2017-08-02 05:56","category":"头条","author_name":"山兔君","url":"http://mini.eastday.com/mobile/170802055625361.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170802/20170802055625_16a08e1e38d107c029c02e1a4ba53cb0_8_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20170802/20170802055625_16a08e1e38d107c029c02e1a4ba53cb0_10_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20170802/20170802055625_16a08e1e38d107c029c02e1a4ba53cb0_5_mwpm_03200403.jpg"},{"uniquekey":"9f70d500938b1dd8c0fd3541a2248936","title":"为什么清兵胸前的字不相同？\u201c勇\u201d是什么？\u201c兵\u201d是什么？","date":"2017-08-02 05:54","category":"头条","author_name":"新奇的历史事","url":"http://mini.eastday.com/mobile/170802055458438.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170802/20170802055458_85f5bef814cd504ae52c3f9b072d9875_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170802/20170802055458_85f5bef814cd504ae52c3f9b072d9875_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170802/20170802055458_85f5bef814cd504ae52c3f9b072d9875_2_mwpm_03200403.jpg"},{"uniquekey":"6e30e428009ebde267c1f1226cc8646a","title":"15个副省级城市 步入服务经济时代 广州、深圳高速领跑","date":"2017-08-02 05:49","category":"头条","author_name":"21世纪经济报道","url":"http://mini.eastday.com/mobile/170802054950854.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170802/20170802054950_bcb0299ff3d2784b6d329d733d0ab8a2_1_mwpm_03200403.jpg"},{"uniquekey":"d9e06b0f6e3db1d9e95f87161e615552","title":"晨起黄金10分钟，让你多活10年！赶紧学起来","date":"2017-08-02 05:20","category":"头条","author_name":"广东医疗","url":"http://mini.eastday.com/mobile/170802052041927.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170802/20170802052041_96f6c13073620805cb5a23bdd85df5f7_5_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170802/20170802052041_96f6c13073620805cb5a23bdd85df5f7_9_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170802/20170802052041_96f6c13073620805cb5a23bdd85df5f7_6_mwpm_03200403.jpg"},{"uniquekey":"edca17fe74f21c0ace646b28daf5ab50","title":"内地男星人气榜：鹿晗第五，马天宇第三，第一名无可争议","date":"2017-08-02 05:15","category":"头条","author_name":"娱圈八妹","url":"http://mini.eastday.com/mobile/170802051513398.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802051513_ce65edaccb30f6ae8f4f0180d6fc5625_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170802/20170802051513_ce65edaccb30f6ae8f4f0180d6fc5625_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170802/20170802051513_ce65edaccb30f6ae8f4f0180d6fc5625_5_mwpm_03200403.jpg"},{"uniquekey":"ee7b036825483a5e053109c3d8d339ee","title":"油价调整最新消息：距离汽油、柴油价格上调 仅剩三天！涨幅多少呢？","date":"2017-08-02 05:10","category":"头条","author_name":"油价汽油柴油查询","url":"http://mini.eastday.com/mobile/170802051005979.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170802/20170802051005_d6c6eb6089fb154df349cb1d097ce135_1_mwpm_03200403.jpg"},{"uniquekey":"1837009a56155bb37d5370521d6ab486","title":"一张升级版上海文体设施布局图绘就 迎新一轮文化空间发展","date":"2017-08-02 05:04","category":"头条","author_name":"解放日报","url":"http://mini.eastday.com/mobile/170802050409305.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170802/20170802050409_d68e60fa04a89cc3757156885427933b_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20170802/20170802050409_d68e60fa04a89cc3757156885427933b_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20170802/20170802050409_d68e60fa04a89cc3757156885427933b_3_mwpm_03200403.jpg"},{"uniquekey":"5a85f13a0a195bdf879f7049c535e41d","title":"一旦股票遇到这五大卖出信号, 立马清仓逃命, 别犹豫","date":"2017-08-02 05:00","category":"头条","author_name":"每日财经微评","url":"http://mini.eastday.com/mobile/170802050047666.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170802/20170802050047_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170802/20170802050047_d41d8cd98f00b204e9800998ecf8427e_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170802/20170802050047_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg"},{"uniquekey":"014b99a373663a6ce85377e0a445a1b3","title":"一个胖女人，曾被张艺谋相中，离婚后找了小15岁老公","date":"2017-08-02 04:54","category":"头条","author_name":"娱三哥","url":"http://mini.eastday.com/mobile/170802045443101.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170802/20170802045443_27ca6f336464df5ebbaf1a692b6bfb05_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170802/20170802045443_27ca6f336464df5ebbaf1a692b6bfb05_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170802/20170802045443_27ca6f336464df5ebbaf1a692b6bfb05_1_mwpm_03200403.jpg"},{"uniquekey":"64588dd15a700c3f8c0c5d995e968ae5","title":"自己做菜没时间，快手菜帮你快速吃上佳肴！","date":"2017-08-02 04:53","category":"头条","author_name":"搞笑美食创意","url":"http://mini.eastday.com/mobile/170802045358391.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170802/20170802045358_dc8c209c9f8f8b610b98b15ccb1ba85b_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170802/20170802045358_dc8c209c9f8f8b610b98b15ccb1ba85b_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170802/20170802045358_dc8c209c9f8f8b610b98b15ccb1ba85b_3_mwpm_03200403.jpg"},{"uniquekey":"6f9dc38f34af6a4651c03ec548bbbc39","title":"小市场关了 便民店来了","date":"2017-08-02 04:53","category":"头条","author_name":"中国青年报","url":"http://mini.eastday.com/mobile/170802045331138.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170802/20170802045331_497182c59f877d0ce33c3d013e4885ca_1_mwpm_03200403.jpg"},{"uniquekey":"a74aa8ed12a5a7fa2b5d2430dfb367c9","title":"这两个个北洋军阀玩转日本人，一个不办事，一个骗回甲午赔款！","date":"2017-08-02 04:49","category":"头条","author_name":"历史尘封","url":"http://mini.eastday.com/mobile/170802044952914.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170802/20170802044952_b6de2aa57e3c621047a7bc06e9307dc6_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170802/20170802044952_b6de2aa57e3c621047a7bc06e9307dc6_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170802/20170802044952_b6de2aa57e3c621047a7bc06e9307dc6_5_mwpm_03200403.jpg"},{"uniquekey":"2b267c0b1b659569fd42838fbd9bd63f","title":"美国牛肉卷土重来，\u201c狼来了\u201d吗？","date":"2017-08-02 04:45","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170802044555927.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170802/20170802044555_7eb2e4b114e9cd57182d11d34fe8a144_1_mwpm_03200403.jpg"},{"uniquekey":"1d29ea9210e468076aa0d438706af143","title":"巴基斯坦国民议会选出新任政府总理","date":"2017-08-02 04:41","category":"头条","author_name":"人民日报","url":"http://mini.eastday.com/mobile/170802044142249.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170802/20170802044142_9fe0860dbdf8b305d3675b5047cb6094_1_mwpm_03200403.jpg"}]
     */

    private String stat;
    private List<DataBean> data;

    public String getStat() {
      return stat;
    }

    public void setStat(String stat) {
      this.stat = stat;
    }

    public List<DataBean> getData() {
      return data;
    }

    public void setData(List<DataBean> data) {
      this.data = data;
    }

    public static class DataBean {

      /**
       * uniquekey : 14e3b8acbce73ad2167373fb34adbd96
       * title : 林志玲录节目素颜曝光 皮肤虽发黄但五官精致
       * date : 2017-08-02 07:37
       * category : 头条
       * author_name : 新浪娱乐
       * url : http://mini.eastday.com/mobile/170802073727564.html
       * thumbnail_pic_s : http://04.imgmini.eastday.com/mobile/20170802/20170802073727_0aee2797dbb21dfa41001c564d312c6e_4_mwpm_03200403.jpg
       * thumbnail_pic_s02 : http://04.imgmini.eastday.com/mobile/20170802/20170802073727_e1bcd93cebc4709bae3dd230d6adc8c8_1_mwpm_03200403.jpg
       * thumbnail_pic_s03 : http://04.imgmini.eastday.com/mobile/20170802/20170802073727_bb33da679aff621e07d9aa0d7a51b770_5_mwpm_03200403.jpg
       */

      private String uniquekey;
      private String title;
      private String date;
      private String category;
      private String author_name;
      private String url;
      private String thumbnail_pic_s;
      private String thumbnail_pic_s02;
      private String thumbnail_pic_s03;

      public String getUniquekey() {
        return uniquekey;
      }

      public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
      }

      public String getTitle() {
        return title;
      }

      public void setTitle(String title) {
        this.title = title;
      }

      public String getDate() {
        return date;
      }

      public void setDate(String date) {
        this.date = date;
      }

      public String getCategory() {
        return category;
      }

      public void setCategory(String category) {
        this.category = category;
      }

      public String getAuthor_name() {
        return author_name;
      }

      public void setAuthor_name(String author_name) {
        this.author_name = author_name;
      }

      public String getUrl() {
        return url;
      }

      public void setUrl(String url) {
        this.url = url;
      }

      public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
      }

      public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
      }

      public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
      }

      public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
      }

      public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
      }

      public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
      }
    }
  }
}
