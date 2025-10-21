package main.java.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 1169. Invalid Transactions
 */
public class InvalidTransactions {
  static class Transaction {
    String name;
    int time;
    int amount;
    String city;
    String original;
    boolean isSuspicious = false;

    Transaction(String record) {
      this.original = record;
      String[] parts = record.split(",");
      this.name = parts[0];
      this.time = Integer.parseInt(parts[1]);
      this.amount = Integer.parseInt(parts[2]);
      this.city = parts[3];
    }
  }

  public List<String> invalidTransactions(String[] transactions) {
    int n = transactions.length;

    List<Transaction> txnList = Arrays.stream(transactions)
      .map(Transaction::new)
      .collect(Collectors.toList());

    Map<String, List<Transaction>> userMap = new HashMap<>();
    for (Transaction t : txnList) {
      userMap.computeIfAbsent(t.name, k -> new ArrayList<>()).add(t);
      t.isSuspicious = t.amount > 1000;
    }

    for (List<Transaction> userTxns : userMap.values()) {
      userTxns.sort(Comparator.comparingInt(t -> t.time));

      for (int i = 0; i < userTxns.size(); i++) {
        Transaction t1 = userTxns.get(i);
        for (int j = i+1; j < userTxns.size(); j++) {
          
          Transaction t2 = userTxns.get(j);
          
          if (t2.time - t1.time > 60) break;

          if (!t1.city.equals(t2.city)) {
            t1.isSuspicious = true;
            t2.isSuspicious = true;
          }
        }
      }
    }

    return txnList.stream()
                      .filter(t -> t.isSuspicious)
                      .map(t -> t.original)
                      .collect(Collectors.toList());
  }
}
