public class Student {
   private String name;
   private String classes;

   public Student() {
       name = "do ba tung";
       classes = "codegym";
   }
   public void setName(String value) {
       name = value;
   }
   public void setClasses(String value) {
       classes = value;
   }
    @Override
    public String toString() {
        return ( "Hoc sinh :" + name + " , thuoc lop :" + classes );
    }
}
