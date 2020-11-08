//TestPackage.java

    import p1.MyCalculator;

    class TestPackage
    {
        public static void main(String[] args)
        {

            MyCalculator M = new MyCalculator();

            System.out.print("\n\n\tThe Sum is : " + M.Add(45,10));
            System.out.print("\n\n\tThe Subtract is :" + M.Subtract(45,10));
            System.out.print("\n\n\tThe Product is :" + M.Product(45,10));

        }
    }