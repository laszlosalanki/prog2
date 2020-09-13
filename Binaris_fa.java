import java.io.FileInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Binaris_fa {

    private int travels = 0;
    private int id = 1;
    private int depth, max_depth, count = 0;
    private double avg_sum, disp_sum = 0;

    public Binaris_fa(int t) {
        tree = root;
        travels = t;
    }

    void addItem(int i) {
        if(i == 1) {
            if(tree.getRightChild() == null) {
                Node newNode = new Node('1', tree.getChildDepth() + 1, id++);

                tree.newRightChild(newNode);

                tree = root;
            }
            else {
                tree = tree.getRightChild();
                depth = tree.getChildDepth();
            }
        }
        else {
            if(tree.getLeftChild() == null) {
                Node newNode = new Node('0', tree.getChildDepth() + 1, id++);

                tree.newLeftChild(newNode);
                tree = root;
            }
            else {
                tree = tree.getLeftChild();
                depth = tree.getChildDepth();
            }
        }
    }

    void combiNode(PrintWriter outstream) {
        int i = travelsInfo();

        switch (i) {
            case 0:
                Pre(root, outstream);
                break;
        
            case 1:
                In(root, outstream);
                break;

            case 2:
                Post(root, outstream);
                break;

            default:
                In(root, outstream);
        }
        Depth(root);
        Avg(root);
        Disp(root);
    }

    public int depthOut() {
        max_depth = depth = 0;
        Depth(root);
        return max_depth;
    }

    public double avgOut() {
        count = 0;
        avg_sum = 0.0;
        Avg(root);
        return avg_sum/count;
    }

    public double dispOut() {
        disp_sum = 0.0;
        Disp(root);
        return Math.sqrt(disp_sum/--count);
    }

    public int maxDepth() {
        return max_depth;
    }

    public void travelSet(int t) {
        travels = t;
    }

    public int travelsInfo() {
        return travels;
    }

    public double treeAvg() {
        return avg_sum/count;
    }
    
    class Node {

        Node left;
        Node right;

        private int id;
		private char value;
		private int depth;

        public Node(char value, int depth, int id) {
            this.value = value;
            this.depth = depth;
            this.id = id;

            left = null;
            right = null;
        }

        public Node getLeftChild() {
            return left;
        }

        public Node getRightChild() {
            return right;
        }

        public void newLeftChild(Node leftNode) {
            left = leftNode;
        }

        public void newRightChild(Node rightNode) {
            right = rightNode;
        }

        public char getChildValue() {
            return value;
        }

        public int getChildDepth() {
            return depth;
        }

        public int getChildId() {
            return id;
        }

    }

    private Node tree = null;
    private Node root = new Node('/', 0, 0);

    public void Depth(Node n) {
        if(n != null) {
            Depth(n.getRightChild());
            if(n.getChildDepth() > max_depth)
                max_depth = n.getChildDepth();
            Depth(n.getLeftChild());
        }
    }

    public void Pre(Node n, PrintWriter outstream) {
        if(n != null) {
            int i;
            for(i = 0; i < n.getChildDepth() + 1; i++)
                outstream.print("---");

            outstream.print(n.getChildValue());
            outstream.print("(");
            outstream.print(n.getChildDepth());
            outstream.println(")");
            Pre(n.getRightChild(), outstream);
            Pre(n.getLeftChild(), outstream);
        }
    }

    public void In(Node n, PrintWriter outstream) {
        if(n != null) {
            int i;

            In(n.getRightChild(), outstream);

            for(i = 0; i < n.getChildDepth() + 1; i++)
                outstream.print("---");

            outstream.print(n.getChildValue());
            outstream.print("(");
            outstream.print(n.getChildDepth());
            outstream.println(")");
            In(n.getLeftChild(), outstream);
        }
    }

    public void Post(Node n, PrintWriter outstream) {
        if(n != null) {
            int i;

            Post(n.getRightChild(), outstream);
            Post(n.getLeftChild(), outstream);

            for(i = 0; i < n.getChildDepth() + 1; i++)
                outstream.print("---");

            outstream.print(n.getChildValue());
            outstream.print("(");
            outstream.print(n.getChildDepth());
            outstream.println(")");
        }
    }

    public void Avg(Node n) {
        if(n != null) {
            if(n.getRightChild() == null && n.getLeftChild() == null) {
                count++;
                avg_sum += n.getChildDepth();
            }
            Avg(n.getRightChild());
            Avg(n.getLeftChild());
        }
    }

    public void Disp(Node n) {
        if(n != null) {
            if(n.getRightChild() == null && n.getLeftChild() == null) {
                disp_sum += (double) ((n.getChildDepth() - treeAvg()) * (n.getChildDepth() - treeAvg()));
            }
            Disp(n.getRightChild());
            Disp(n.getLeftChild());
        } 
    }

    public static void main(String[] args) {

        if(args.length != 4) {
            System.out.println("Hasznalata:\n./binma bemeneti_fajl -o kimeneti_fajl [bejaras](pre = 0,in = 1,post = 2) default:1");
            System.exit(-1);
        }

        if(!"-o".equals(args[1])) {
            System.out.println("Hasznalata:\n./binma bemeneti_fajl -o kimeneti_fajl [bejaras](pre = 0,in = 1,post = 2) default:1");
            System.exit(-1);
        }

        int travelsL = Integer.parseInt(args[3]);

        try {
            FileInputStream in = new FileInputStream(new File(args[0]));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(args[2])));
            byte[] b = new byte[1];

            Binaris_fa binfa = new Binaris_fa(travelsL);

            while(in.read(b) != -1) {
                if(b[0] == 0x0a) {
                    break;
                }
            }

            boolean comment = false;

            while(in.read(b) != -1) {
                if(b[0] == 0x3e) {  // > char
                    comment = true;
                    continue;
                }

                if(b[0] == 0x0a) {  // new row
                    comment = false;
                    continue;
                }

                if(comment)
                    continue;

                if(b[0] == 0x4e)  // N char
                    continue;

                for(int i = 0; i < 8; ++i) {
                    if((b[0] & 0x80) != 0)
                        binfa.addItem(1);
                    else
                        binfa.addItem(0);
                    
                    b[0] <<= 1;
                }
            }

                binfa.combiNode(out);
                out.println("depth = " + binfa.maxDepth());
                out.println("avg = " + binfa.avgOut());
                out.println("var = " + binfa.dispOut());
                out.close();
                in.close();
                
        } catch(java.io.FileNotFoundException fNFE) {
            fNFE.printStackTrace();
        } catch(java.io.IOException ioE) {
            ioE.printStackTrace();
        }
    }

}