import java.util.HashMap;
import java.util.Map;

public class InMemoryDBImpl implements InMemoryDB {

    private Map<String, Integer> db = new HashMap<>();
    private Map<String, Integer> transaction = null;

    @Override
    public Integer get(String key) {
        return db.getOrDefault(key, null);
}

    @Override
    public void put(String key, int val) {
        if (transaction == null) {
            throw new IllegalStateException("Error: No open transaction.");
        }
        transaction.put(key, val);
    }

    @Override
    public void begin_transaction() {
        if (transaction != null) {
            throw new IllegalStateException("Error: A transaction is already in progress.");
        }
        transaction = new HashMap<>();
    }

    @Override
    public void commit() {
        if (transaction == null) {
            throw new IllegalStateException("Error: No open transaction to commit.");
        }
        for (Map.Entry<String, Integer> entry : transaction.entrySet()) {
            db.put(entry.getKey(), entry.getValue());
        }
        transaction = null;
    }

    @Override
    public void rollback() {
        if (transaction == null) {
            throw new IllegalStateException("Error: No open transaction to rollback.");
        }
        transaction = null;
    }
}
