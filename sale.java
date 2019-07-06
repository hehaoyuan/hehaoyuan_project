package www.bit.hhy;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.time.LocalDate;


/**
 * 商品类
 * Author:qqy
 */
class Goods {
    private String id;
    private String name;
    private double price;

    public Goods(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("[%2s] %s %.2f",this.getId(),this.getName(),this.getPrice());
    }
}




/**
 * 订单类
 * Author:qqy
 */
class Order {
    //订单创建完成之后，订单编号不能修改
    private final String orderId;

    //商品信息 -> 商品标号，商品数量
    //订单创建完成后，goodsInfo属性实例化HashMap
    private final Map<String, Integer> goodsInfo = new HashMap<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 添加商品
     * @param goodsId 商品编号
     * @param count   数量
     */
    public void add(String goodsId, Integer count) {
        //sum -> 改变后的商品数量
        Integer sum = this.goodsInfo.get(goodsId);
        //当前订单中不存在该商品
        if (sum == null) {
            sum = count;
        } else {
            sum += count;
        }
        //将新的商品数量与商品编号关联起来
        this.goodsInfo.put(goodsId, sum);
    }

    /**
     * 减少商品
     * @param goodsId
     * @param count
     */
    public void cancel(String goodsId, Integer count) {
        Integer sum = this.goodsInfo.get(goodsId);
        //当前订单存在该商品
        if (sum != null) {
            sum-=count;
            if(sum<=0){
                this.goodsInfo.remove(goodsId);
            }else{
                this.goodsInfo.put(goodsId,sum);
            }
        }
    }

    /**
     * 清空所有商品
     */
    public void clear() {
        System.out.println("清空本次订单中的所有信息...");
        this.goodsInfo.clear();
    }

    /**
     * 获得订单编号
     * @return
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 获得订单信息
     * @return
     */
    public Map<String, Integer> getOrderInfo() {
        return this.goodsInfo;
    }
}


/**
 * 商品管理
 * Author:qqy
 */
interface GoodsCenter {
    /**
     * 添加商品
     * @param good 商品
     */
    void addGoods(Goods good);

    /**
     * 删除商品（通过商品编号）
     * @param goodId
     */
    void removeGoods(String goodId);

    /**
     * 更新商品（修改当前商品编号对应商品的名称）
     * @param good
     */
    void updateGoods(Goods good);

    /**
     * 商品是否存在（通过商品编号）
     * @param goodId
     * @return
     */
    boolean isExistGoods(String goodId);

    /**
     * 获取商品（通过商品编号）
     * @param goodId
     * @return
     */
    Goods getGoods(String goodId);

    /**
     * 列出商品信息
     * @return
     */
    String listGoods();

    /**
     * 存储商品信息
     */
    void store();

    /**
     * 加载商品信息
     */
    void load();
}


/**
 * 订单管理
 * Author:qqy
 */
interface OrderCenter {
    /**
     * 添加订单
     * @param order 订单
     */
    void addOrder(Order order);

    /**
     * 删除订单
     * @param orderId
     */
    void removeOrder(String orderId);

    /**
     * 列出所有订单信息
     * @return
     */
    String ordersTable();

    /**
     * 列出当前订单信息（通过订单编号）
     * @param orderId
     * @return
     */
    String orderTable(String orderId);

    /**
     * 存储订单信息
     */
    void storeOrders();


    /**
     * 加载订单信息
     */
    String loadOrders();

    /**
     * 清空所有订单信息
     */
    void cleanOrders();
}






/**
 * Author:qqy
 */
class GoodsCenterImpl implements GoodsCenter {
    //创建商品集合，key -> 商品编号，value -> 商品名称
    private final Map<String, Goods> goodsMap = new HashMap<>();

    //将商品信息保存至goods.txt
    private String filePath = System.getProperty("user.dir") + File.separator + "goods.txt";

    @Override
    public void addGoods(Goods good) {
        this.goodsMap.put(good.getId(), good);
    }

    @Override
    public void removeGoods(String goodId) {
        this.goodsMap.remove(goodId);
    }

    //修改存在商品的名称
    @Override
    public void updateGoods(Goods good) {
        if (this.goodsMap.containsKey(good.getId())) {
            this.goodsMap.put(good.getId(), good);
        }
    }

    @Override
    public boolean isExistGoods(String goodId) {
        return this.goodsMap.containsKey(goodId);
    }

    @Override
    public Goods getGoods(String goodId) {
        return this.goodsMap.get(goodId);
    }

    @Override
    public String listGoods() {
        StringBuilder str = new StringBuilder();
        str.append("************** 商品信息 **************\n");
        str.append("\t编号\t\t\t名称\t\t\t单价\n");
        //根据商品名称获取商品信息
        for (Goods good : this.goodsMap.values()) {
            str.append("\t" + good.getId() + "\t\t\t" + good.getName() + "\t\t\t" + good.getPrice() + "\n");
        }
        str.append("*************************************\n");
        return str.toString();
    }

    @Override
    public void store() {
        System.out.println("保存所有商品信息到文件，每个商品信息 -> 编号：名称：价格");
        //将商品信息输出到goods.txt
        //输出格式 -> 商品编号：商品名称：商品价格
        File file = new File(filePath);
        //自动关闭流
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(file)
        )) {
            for (Goods goods : this.goodsMap.values()) {
                writer.write(String.format("%s:%s:%.2f\n", goods.getId(), goods.getName(), goods.getPrice()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        //读取goods.txt中的商品信息，经过处理，存入商品集合
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file)
        )) {
            String read;
            while((read=reader.readLine())!=null){
                String[] values=read.split(":");
                if(values.length==3){
                    Goods good=new Goods(values[0],values[1],Double.parseDouble(values[2]));
                    this.addGoods(good);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





/**
 * Author:qqy
 */
class OrderCenterImpl implements OrderCenter {
    private GoodsCenter goodsCenter;

    public OrderCenterImpl(GoodsCenter goodsCenter) {
        this.goodsCenter = goodsCenter;
    }

    //创建订单集合，key -> 订单编号，value -> 订单信息
    private final Map<String, Order> orderMap = new HashMap<>();

    private String filePath = System.getProperty("user.dir") + File.separator + "order.txt";

    @Override
    public void addOrder(Order order) {
        this.orderMap.put(order.getOrderId(), order);
    }

    @Override
    public void removeOrder(String orderId) {
        this.orderMap.remove(orderId);
    }

    @Override
    public String ordersTable() {
        StringBuilder str = new StringBuilder();
        str.append("=================所有订单=================\n");
        str.append("\t编号\t\t\t总价\n");

        for (Order order : this.orderMap.values()) {
            Map<String, Integer> totalOrder = order.getOrderInfo();
            double everyPrice = 0.0;
            //商品集合，key -> 商品编号，value -> 商品数量
            for (Map.Entry<String, Integer> entry : totalOrder.entrySet()) {
                String goodId = entry.getKey();
                Integer goodCount = entry.getValue();
                Goods good = goodsCenter.getGoods(goodId);
                everyPrice += good.getPrice() * goodCount;
                str.append("\t" + goodId + "\t\t\t" + everyPrice + "\n");
            }
            str.append("=========================================\n");
        }
        return str.toString();
    }

    @Override
    public String orderTable(String orderId) {
        Order order = this.orderMap.get(orderId);
        StringBuilder str = new StringBuilder();
        str.append("=================订单信息=================\n");
        str.append("编号：" + order.getOrderId() + "\n");
        str.append("打印时间：" + LocalDate.now().toString()+"\n");
        str.append("=========================================\n");
        str.append("编号\t\t\t名称\t\t\t数量\t\t\t单价\n");
        double totalPrice = 0.0;
        for (Map.Entry<String, Integer> entry : order.getOrderInfo().entrySet()) {
            Goods good = goodsCenter.getGoods(entry.getKey());
            str.append("" + good.getId() + "\t\t\t" + good.getName() + "\t\t\t"+entry.getValue()+"\t\t\t"+ good.getPrice() + "\n");
            totalPrice += entry.getValue() * good.getPrice();
        }
        str.append("=========================================\n");
        str.append("总价：" + totalPrice + "\n");
        str.append("=========================================\n");
        return str.toString();
    }

    @Override
    public void storeOrders() {
        System.out.println("保存所有订单到文件，每个订单信息 -> 编号和总价");
        //将所有订单信息保存至order.txt
        //输出格式 -> 编号：总价
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(file)
        )) {
            for(Order order:this.orderMap.values()){
                double totalPrice = 0.0;
                for (Map.Entry<String, Integer> entry : order.getOrderInfo().entrySet()) {
                    totalPrice += entry.getValue() *goodsCenter.getGoods(entry.getKey()).getPrice();
                }
                writer.write(String.format("%s:%.2f\n",order.getOrderId(),totalPrice));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String loadOrders() {
        File file = new File(filePath);
        StringBuilder str = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file)
        )) {
            String read;
            if ((file.length() == 0)){
                System.out.println("请先保存订单信息！！！");
            }else{
                System.out.println("加载文件中的订单信息...");
                double price;
                str.append("=================所有订单=================\n");
                str.append("\t编号\t\t\t总价\n");
                while ((read = reader.readLine()) != null) {
                    String[] values = read.split(":");
                    if (values.length == 2) {
                        Order order = new Order(values[0]);
                        price = Double.parseDouble(values[1]);
                        this.addOrder(order);
                        str.append("\t" + order.getOrderId() + "\t\t\t" + price + "\n");
                    }
                }
                str.append("=========================================\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    @Override
    public void cleanOrders() {
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file)
        ) {
            fileWriter.write("");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




/**
 * 字符界面收银台(优化版)
 * Author:qqy
 */
class sale {
    private static Scanner scanner = new Scanner(System.in);

    //商品中心管理
    private static GoodsCenter goodsCenter = new GoodsCenterImpl();

    //订单中心管理，先实例化商品中心，因为订单中心的实例化需要传一个商品中心的实例化对象
    private static OrderCenter orderCenter = new OrderCenterImpl(goodsCenter);

    private static Integer orderId = 0;


    public static void helpInfo() {
        System.out.println("*************** 欢迎使用简易收银台 *****************");
        System.out.println(" [U] 使用 [S] 设置 [P] 保存所有信息 [A] 关于 [Q] 退出 ");
        System.out.println("            输入:  U S P A Q 进入操作               ");
        System.out.println("*************************************************");
    }

    public static void quit() {
        System.out.println("*************************************************");
        System.out.println("                欢迎使用，下次再见                 ");
        System.out.println("*************************************************");
        System.exit(0);
    }

    public static void about() {
        System.out.println("******************** 关于 ***********************");
        System.out.println("        名称：简易收银台                          ");
        System.out.println("        功能：基于字符界面的收银台操作系统          ");
        System.out.println("        作者: qqy                               ");
        System.out.println("        版本: v1.0.0                          ");
        System.out.println("        意见反馈：*********@qq.com            ");
        System.out.println("*************************************************");
    }

    public static void usageInfo() {
        System.out.println("******************* 买单功能 ********************");
        System.out.println("  [S] 查看当前订单 [U] 查看所有订单 [A] 下单 [C]清空   ");
        System.out.println("     [D] 取消 [L] 浏览商品 [P] 保存订单 [R] 返回   ");
        System.out.println("          输入:  S U A C D L P R 进入操作              ");
        System.out.println("*************************************************");
    }

    public static void settingInfo() {
        System.out.println("******************* 设置功能 ********************");
        System.out.println("           [S] 查看 [A] 上架 [D] 下架        ");
        System.out.println("         [U] 修改 [P] 保存商品 [R] 返回   ");
        System.out.println("          输入:  S A D U P R 进入操作              ");
        System.out.println("*************************************************");
    }

    public static void usage() {
        //创建订单，并且添加到订单管理中心
        Order order = new Order(String.valueOf(++orderId));
        orderCenter.addOrder(order);

        usageInfo();
        System.out.println(orderCenter.orderTable(order.getOrderId()));
        while (true) {
            String line = scanner.nextLine();
            switch (line.trim().toUpperCase()) {
                case "S": {
                    System.out.println(orderCenter.orderTable(order.getOrderId()));
                    break;
                }
                case "A": {
                    System.out.println("请输入下单信息[编号 数量]（如下格式：1  2 ）:");
                    String value = scanner.nextLine().trim();
                    String[] infoArray = value.split(" ");
                    if (infoArray.length == 2) {
                        Goods goods = goodsCenter.getGoods(infoArray[0].trim());
                        if (goods != null) {
                            order.add(infoArray[0].trim(), Integer.parseInt(infoArray[1].trim()));
                            System.out.println(orderCenter.orderTable(order.getOrderId()));
                            break;
                        }
                    }
                    if (!(goodsCenter.isExistGoods(infoArray[0]))) {
                        System.out.println("!商品还未上架，请重新选择商品");
                    }
                    System.out.println("请按照格式要求输入信息");
                    break;
                }
                case "D": {
                    System.out.println("请输入取消信息[编号 数量]（如下格式：1  2 ）:");
                    String value = scanner.nextLine().trim();
                    String[] infoArray = value.split(" ");
                    if (infoArray.length == 2) {
                        Goods goods = goodsCenter.getGoods(infoArray[0].trim());
                        if (goods != null) {
                            order.cancel(infoArray[0], Integer.parseInt(infoArray[1].trim()));
                            System.out.println(orderCenter.orderTable(order.getOrderId()));
                            break;
                        }
                    }
                    System.out.println("请按照格式要求输入信息");
                    break;
                }
                case "U": {
                    System.out.println(orderCenter.loadOrders());
                    break;
                }
                case "L": {
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "C":{
                    order.clear();
                    break;
                }
                case "P": {
                    //订单信息保存
                    orderCenter.storeOrders();
                    break;
                }
                case "R": {
                    return;
                }
                default: {
                    usageInfo();
                }
            }
        }
    }

    public static void setting() {
        settingInfo();
        while (true) {
            String line = scanner.nextLine();
            switch (line.toUpperCase()) {
                case "S": {
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "A": {
                    System.out.println("请输入上架商品信息（如下格式：1 餐巾纸 1.4）:");
                    Goods goods = readGoods(true);
                    if (goods == null) {
                        System.out.println("!请按照格式要求输入信息");
                        break;
                    }
                    if (goodsCenter.isExistGoods(goods.getId())) {
                        System.out.println("!上架商品已经存在，请重新上架");
                    } else {
                        goodsCenter.addGoods(goods);
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "D": {
                    System.out.println("请输入下架商品信息编号（如下格式：1 ）:");
                    Goods goods = readGoods(false);
                    if (goods == null) {
                        System.out.println("!请输入存在的商品");
                        break;
                    }else{
                        goodsCenter.removeGoods(goods.getId());
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "U": {
                    System.out.println("请输入修改商品信息（如下格式：1 餐巾纸 1.4 ）");
                    Goods goods = readGoods(false);
                    if (goods == null) {
                        System.out.println("!请输入存在的商品");
                        break;
                    }else {settingInfo();
                        goodsCenter.updateGoods(goods);
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "P": {
                    //商品信息保存
                    goodsCenter.store();
                    break;
                }
                case "R": {
                    return;
                }
                default: {
                    settingInfo();
                }
            }
        }
    }

    public static Goods readGoods(boolean flag) {
        String value = scanner.nextLine();
        String[] infoArray = value.split(" ");
        if (infoArray.length == 3 || infoArray.length == 1) {
            if (infoArray.length == 3) {
                if (!(sale.isNumber(infoArray[0].trim())&& sale.isNumber(infoArray[2].trim()))){
                    System.out.println("！商品编号或单价有误，请重新输入");
                }else {
                    if (!flag) {
                        if (goodsCenter.isExistGoods(infoArray[0])) {
                            Goods goods = new Goods(infoArray[0], infoArray[1], Double.parseDouble(infoArray[2]));
                            return goods;
                        }
                    }
                    else{
                        Goods goods = new Goods(infoArray[0], infoArray[1], Double.parseDouble(infoArray[2]));
                        return goods;
                    }
                }
            }
            //infoArray.length == 1
            if (!(sale.isNumber(infoArray[0].trim()))){
                System.out.println("！商品编号有误，请重新输入");
            }else{
                if(goodsCenter.isExistGoods(infoArray[0])){
                    Goods goods = new Goods(infoArray[0], "", 0.0D);
                    return goods;
                }
            }
        }
        return null;
    }

    public static boolean isNumber(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        helpInfo();
        goodsCenter.load();
        //每次打开项目，清空订单记录
        //新下单后存储信息后，才可查看所有订单。
        orderCenter.cleanOrders();
        while (true) {
            String line = scanner.nextLine();
            switch (line.trim().toUpperCase()) {
                case "U":
                    usage();
                    helpInfo();
                    break;
                case "S":
                    setting();
                    helpInfo();
                    break;
                case "A":
                    about();
                    break;

                case "P":
                    goodsCenter.store();
                    orderCenter.storeOrders();
                    break;
                case "Q":
                    quit();
                    break;
                default:
                    helpInfo();
            }
        }
    }
}