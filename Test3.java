//package www.bit.hhy;
//
//import com.sun.java.util.jar.pack.ConstantPool;
//
///**
// * @Information:双向链表
// * @Author: HeHaoYuan
// * @Date: Created at 17:58 on 2019/5/21
// * @Package_Name: www.bit.hhy
// */
//
//
//class TwoWayLinkedList implements IDoubleLinked {
//    private Node head;//表示链表头
//    private Node last;//表示链表尾
//    private int size;//表示链表的节点个数
//
//    private class Node {
//        private Object data;
//        private Node next;
//        private Node prev;
//
//        public Node(Object data) {
//            this.data = data;
//        }
//    }
//
//    public TwoWayLinkedList() {
//        size = 0;
//        head = null;
//        last = null;
//    }
//
//    //头插法
//    public void addFirst(Object value) {
//        Node node = new Node(value);
//        if (this.head == null) {
//            this.head = node;
//            this.last = node;
//        } else {
//            node.next = this.head;
//            this.head.prev = node;
//            this.head = node;
//        }
//
//    }
//    private void checkIndex(int index) {
//        if(index < 0 || index > getLength()){
//            throw new UnsupportedOperationException("index位置不合法");
//        }
//    }
//
//    private Node searchIndex(int Index){
//        checkIndex(Index);
//        int count=0;
//        Node cur=this.head;
//        while (count!=Index){
//            cur=cur.next;
//            count++;
//
//        }
//
//        return  cur;
//
//
//    }
//
//
//    @Override
//    public boolean addindex(int index, int data) {
//        if(index==0){
//            addFirst(data);
//            return true;
//        }
//        if(index==getLength()){
//            addLast(data);
//            return true;
//        }
//
//        Node cur=searchIndex(index);
//
//        Node node=new Node(data);
//        node.next=cur;
//        node.prev=cur.prev;
//        node.next.prev=node;
//        node.prev.next=node;
//        return true;
//
//    }
//
//    private boolean contain(int key){
//        Node cur=this.head;
//        while(cur!=null){
//            if(cur.data==key){
//
//            }
//        }
//        return true;
//    }
//
//    public int remove(int key){
//        Node cur=this.head;
//        int oldData=0;
//        if(cur.)
//
//
//
//    }
//
//    //尾插法
//    public void addTail(Object value) {
//        Node node = new Node(value);
//        if (size == 0) {
//            head = node;
//            last = node;
//            size++;
//        } else {
//            node.prev = last;
//            last.next = node;
//            last = node;
//            size++;
//        }
//    }
//
//
//    public void addLast(Object value) {
//        Node node = new Node(value);
//        if (this.head == null) {
//            this.head = head;
//            this.last = last;
//        } else {
//            this.last.next = node;
//            node.prev = this.last;
//            this.last = node;
//
//
//        }
//
//
//    }
//
//
//    //删除链表头
//    public Node deleteHead() {
//        Node temp = head;
//        if (size != 0) {
//            head = head.next;
//            head.prev = null;
//            size--;
//        }
//        return temp;
//    }
//
//    //删除链表尾
//    public Node deleteTail() {
//        Node temp = last;
//        if (size != 0) {
//            last = last.prev;
//            last.next = null;
//            size--;
//        }
//        return temp;
//    }
//
//    //获得链表的节点个数
//    public int getSize() {
//        return size;
//    }
//
//    //判断链表是否为空
//    public boolean isEmpty() {
//        return (size == 0);
//    }
//
//
//    public void display() {
//        if (this.head == null) {
//            return;
//        }
//
//        Node cur = this.head;
//        while (cur != null) {
//            System.out.println("No");
//        }
//    }
//
//}
//
//
// interface IDoubleLinked {
//    //头插法
//    void addFirst(int data);
//    //尾插法
//    void addLast(int data);
//    //任意位置插入,第一个数据节点为0号下标
//    boolean addindex(int index,int data);
//    //查找是否包含关键字key是否在单链表当中
//    boolean contains(int key);
//    //删除第一次出现关键字为key的节点
//    int remove(int key);
//    //删除所有值为key的节点
//    void removeAllKey(int key);
//    //得到单链表的长度
//    int getLength();
//    void display();
//    void clear();
//}
//
//
