package www.bit.hhy;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.time.LocalDate;


/**
 * ��Ʒ��
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
 * ������
 * Author:qqy
 */
class Order {
    //�����������֮�󣬶�����Ų����޸�
    private final String orderId;

    //��Ʒ��Ϣ -> ��Ʒ��ţ���Ʒ����
    //����������ɺ�goodsInfo����ʵ����HashMap
    private final Map<String, Integer> goodsInfo = new HashMap<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    /**
     * �����Ʒ
     * @param goodsId ��Ʒ���
     * @param count   ����
     */
    public void add(String goodsId, Integer count) {
        //sum -> �ı�����Ʒ����
        Integer sum = this.goodsInfo.get(goodsId);
        //��ǰ�����в����ڸ���Ʒ
        if (sum == null) {
            sum = count;
        } else {
            sum += count;
        }
        //���µ���Ʒ��������Ʒ��Ź�������
        this.goodsInfo.put(goodsId, sum);
    }

    /**
     * ������Ʒ
     * @param goodsId
     * @param count
     */
    public void cancel(String goodsId, Integer count) {
        Integer sum = this.goodsInfo.get(goodsId);
        //��ǰ�������ڸ���Ʒ
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
     * ���������Ʒ
     */
    public void clear() {
        System.out.println("��ձ��ζ����е�������Ϣ...");
        this.goodsInfo.clear();
    }

    /**
     * ��ö������
     * @return
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * ��ö�����Ϣ
     * @return
     */
    public Map<String, Integer> getOrderInfo() {
        return this.goodsInfo;
    }
}


/**
 * ��Ʒ����
 * Author:qqy
 */
interface GoodsCenter {
    /**
     * �����Ʒ
     * @param good ��Ʒ
     */
    void addGoods(Goods good);

    /**
     * ɾ����Ʒ��ͨ����Ʒ��ţ�
     * @param goodId
     */
    void removeGoods(String goodId);

    /**
     * ������Ʒ���޸ĵ�ǰ��Ʒ��Ŷ�Ӧ��Ʒ�����ƣ�
     * @param good
     */
    void updateGoods(Goods good);

    /**
     * ��Ʒ�Ƿ���ڣ�ͨ����Ʒ��ţ�
     * @param goodId
     * @return
     */
    boolean isExistGoods(String goodId);

    /**
     * ��ȡ��Ʒ��ͨ����Ʒ��ţ�
     * @param goodId
     * @return
     */
    Goods getGoods(String goodId);

    /**
     * �г���Ʒ��Ϣ
     * @return
     */
    String listGoods();

    /**
     * �洢��Ʒ��Ϣ
     */
    void store();

    /**
     * ������Ʒ��Ϣ
     */
    void load();
}


/**
 * ��������
 * Author:qqy
 */
interface OrderCenter {
    /**
     * ��Ӷ���
     * @param order ����
     */
    void addOrder(Order order);

    /**
     * ɾ������
     * @param orderId
     */
    void removeOrder(String orderId);

    /**
     * �г����ж�����Ϣ
     * @return
     */
    String ordersTable();

    /**
     * �г���ǰ������Ϣ��ͨ��������ţ�
     * @param orderId
     * @return
     */
    String orderTable(String orderId);

    /**
     * �洢������Ϣ
     */
    void storeOrders();


    /**
     * ���ض�����Ϣ
     */
    String loadOrders();

    /**
     * ������ж�����Ϣ
     */
    void cleanOrders();
}






/**
 * Author:qqy
 */
class GoodsCenterImpl implements GoodsCenter {
    //������Ʒ���ϣ�key -> ��Ʒ��ţ�value -> ��Ʒ����
    private final Map<String, Goods> goodsMap = new HashMap<>();

    //����Ʒ��Ϣ������goods.txt
    private String filePath = System.getProperty("user.dir") + File.separator + "goods.txt";

    @Override
    public void addGoods(Goods good) {
        this.goodsMap.put(good.getId(), good);
    }

    @Override
    public void removeGoods(String goodId) {
        this.goodsMap.remove(goodId);
    }

    //�޸Ĵ�����Ʒ������
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
        str.append("************** ��Ʒ��Ϣ **************\n");
        str.append("\t���\t\t\t����\t\t\t����\n");
        //������Ʒ���ƻ�ȡ��Ʒ��Ϣ
        for (Goods good : this.goodsMap.values()) {
            str.append("\t" + good.getId() + "\t\t\t" + good.getName() + "\t\t\t" + good.getPrice() + "\n");
        }
        str.append("*************************************\n");
        return str.toString();
    }

    @Override
    public void store() {
        System.out.println("����������Ʒ��Ϣ���ļ���ÿ����Ʒ��Ϣ -> ��ţ����ƣ��۸�");
        //����Ʒ��Ϣ�����goods.txt
        //�����ʽ -> ��Ʒ��ţ���Ʒ���ƣ���Ʒ�۸�
        File file = new File(filePath);
        //�Զ��ر���
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
        //��ȡgoods.txt�е���Ʒ��Ϣ����������������Ʒ����
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

    //�����������ϣ�key -> ������ţ�value -> ������Ϣ
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
        str.append("=================���ж���=================\n");
        str.append("\t���\t\t\t�ܼ�\n");

        for (Order order : this.orderMap.values()) {
            Map<String, Integer> totalOrder = order.getOrderInfo();
            double everyPrice = 0.0;
            //��Ʒ���ϣ�key -> ��Ʒ��ţ�value -> ��Ʒ����
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
        str.append("=================������Ϣ=================\n");
        str.append("��ţ�" + order.getOrderId() + "\n");
        str.append("��ӡʱ�䣺" + LocalDate.now().toString()+"\n");
        str.append("=========================================\n");
        str.append("���\t\t\t����\t\t\t����\t\t\t����\n");
        double totalPrice = 0.0;
        for (Map.Entry<String, Integer> entry : order.getOrderInfo().entrySet()) {
            Goods good = goodsCenter.getGoods(entry.getKey());
            str.append("" + good.getId() + "\t\t\t" + good.getName() + "\t\t\t"+entry.getValue()+"\t\t\t"+ good.getPrice() + "\n");
            totalPrice += entry.getValue() * good.getPrice();
        }
        str.append("=========================================\n");
        str.append("�ܼۣ�" + totalPrice + "\n");
        str.append("=========================================\n");
        return str.toString();
    }

    @Override
    public void storeOrders() {
        System.out.println("�������ж������ļ���ÿ��������Ϣ -> ��ź��ܼ�");
        //�����ж�����Ϣ������order.txt
        //�����ʽ -> ��ţ��ܼ�
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
                System.out.println("���ȱ��涩����Ϣ������");
            }else{
                System.out.println("�����ļ��еĶ�����Ϣ...");
                double price;
                str.append("=================���ж���=================\n");
                str.append("\t���\t\t\t�ܼ�\n");
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
 * �ַ���������̨(�Ż���)
 * Author:qqy
 */
class sale {
    private static Scanner scanner = new Scanner(System.in);

    //��Ʒ���Ĺ���
    private static GoodsCenter goodsCenter = new GoodsCenterImpl();

    //�������Ĺ�����ʵ������Ʒ���ģ���Ϊ�������ĵ�ʵ������Ҫ��һ����Ʒ���ĵ�ʵ��������
    private static OrderCenter orderCenter = new OrderCenterImpl(goodsCenter);

    private static Integer orderId = 0;


    public static void helpInfo() {
        System.out.println("*************** ��ӭʹ�ü�������̨ *****************");
        System.out.println(" [U] ʹ�� [S] ���� [P] ����������Ϣ [A] ���� [Q] �˳� ");
        System.out.println("            ����:  U S P A Q �������               ");
        System.out.println("*************************************************");
    }

    public static void quit() {
        System.out.println("*************************************************");
        System.out.println("                ��ӭʹ�ã��´��ټ�                 ");
        System.out.println("*************************************************");
        System.exit(0);
    }

    public static void about() {
        System.out.println("******************** ���� ***********************");
        System.out.println("        ���ƣ���������̨                          ");
        System.out.println("        ���ܣ������ַ����������̨����ϵͳ          ");
        System.out.println("        ����: qqy                               ");
        System.out.println("        �汾: v1.0.0                          ");
        System.out.println("        ���������*********@qq.com            ");
        System.out.println("*************************************************");
    }

    public static void usageInfo() {
        System.out.println("******************* �򵥹��� ********************");
        System.out.println("  [S] �鿴��ǰ���� [U] �鿴���ж��� [A] �µ� [C]���   ");
        System.out.println("     [D] ȡ�� [L] �����Ʒ [P] ���涩�� [R] ����   ");
        System.out.println("          ����:  S U A C D L P R �������              ");
        System.out.println("*************************************************");
    }

    public static void settingInfo() {
        System.out.println("******************* ���ù��� ********************");
        System.out.println("           [S] �鿴 [A] �ϼ� [D] �¼�        ");
        System.out.println("         [U] �޸� [P] ������Ʒ [R] ����   ");
        System.out.println("          ����:  S A D U P R �������              ");
        System.out.println("*************************************************");
    }

    public static void usage() {
        //����������������ӵ�������������
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
                    System.out.println("�������µ���Ϣ[��� ����]�����¸�ʽ��1  2 ��:");
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
                        System.out.println("!��Ʒ��δ�ϼܣ�������ѡ����Ʒ");
                    }
                    System.out.println("�밴�ո�ʽҪ��������Ϣ");
                    break;
                }
                case "D": {
                    System.out.println("������ȡ����Ϣ[��� ����]�����¸�ʽ��1  2 ��:");
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
                    System.out.println("�밴�ո�ʽҪ��������Ϣ");
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
                    //������Ϣ����
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
                    System.out.println("�������ϼ���Ʒ��Ϣ�����¸�ʽ��1 �ͽ�ֽ 1.4��:");
                    Goods goods = readGoods(true);
                    if (goods == null) {
                        System.out.println("!�밴�ո�ʽҪ��������Ϣ");
                        break;
                    }
                    if (goodsCenter.isExistGoods(goods.getId())) {
                        System.out.println("!�ϼ���Ʒ�Ѿ����ڣ��������ϼ�");
                    } else {
                        goodsCenter.addGoods(goods);
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "D": {
                    System.out.println("�������¼���Ʒ��Ϣ��ţ����¸�ʽ��1 ��:");
                    Goods goods = readGoods(false);
                    if (goods == null) {
                        System.out.println("!��������ڵ���Ʒ");
                        break;
                    }else{
                        goodsCenter.removeGoods(goods.getId());
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "U": {
                    System.out.println("�������޸���Ʒ��Ϣ�����¸�ʽ��1 �ͽ�ֽ 1.4 ��");
                    Goods goods = readGoods(false);
                    if (goods == null) {
                        System.out.println("!��������ڵ���Ʒ");
                        break;
                    }else {settingInfo();
                        goodsCenter.updateGoods(goods);
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "P": {
                    //��Ʒ��Ϣ����
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
                    System.out.println("����Ʒ��Ż򵥼���������������");
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
                System.out.println("����Ʒ�����������������");
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
        //ÿ�δ���Ŀ����ն�����¼
        //���µ���洢��Ϣ�󣬲ſɲ鿴���ж�����
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