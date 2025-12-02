public class Main {
    public static void main(String[] args) {
        InMemoryDB db = new InMemoryDBImpl();

        System.out.println(db.get("A"));

        try {
            db.put("A", 5);    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        db.begin_transaction();
        db.put("A", 5);
        System.out.println(db.get("A"));  

        db.put("A", 6);
        db.commit();

        System.out.println(db.get("A")); 

        try {
            db.commit();                  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            db.rollback();                
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(db.get("B"));  

        db.begin_transaction();
        db.put("B", 10);
        db.rollback();

        System.out.println(db.get("B"));  
    }
}
