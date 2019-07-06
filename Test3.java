//package www.bit.hhy;
//
//import com.sun.java.util.jar.pack.ConstantPool;
//
///**
// * @Information:˫������
// * @Author: HeHaoYuan
// * @Date: Created at 17:58 on 2019/5/21
// * @Package_Name: www.bit.hhy
// */
//
//
//class TwoWayLinkedList implements IDoubleLinked {
//    private Node head;//��ʾ����ͷ
//    private Node last;//��ʾ����β
//    private int size;//��ʾ����Ľڵ����
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
//    //ͷ�巨
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
//            throw new UnsupportedOperationException("indexλ�ò��Ϸ�");
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
//    //β�巨
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
//    //ɾ������ͷ
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
//    //ɾ������β
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
//    //�������Ľڵ����
//    public int getSize() {
//        return size;
//    }
//
//    //�ж������Ƿ�Ϊ��
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
//    //ͷ�巨
//    void addFirst(int data);
//    //β�巨
//    void addLast(int data);
//    //����λ�ò���,��һ�����ݽڵ�Ϊ0���±�
//    boolean addindex(int index,int data);
//    //�����Ƿ�����ؼ���key�Ƿ��ڵ�������
//    boolean contains(int key);
//    //ɾ����һ�γ��ֹؼ���Ϊkey�Ľڵ�
//    int remove(int key);
//    //ɾ������ֵΪkey�Ľڵ�
//    void removeAllKey(int key);
//    //�õ�������ĳ���
//    int getLength();
//    void display();
//    void clear();
//}
//
//
