
We’ll compare **Fractional Knapsack**, **0/1 Knapsack**, and **Unbounded Knapsack**.

---

## 📦 **What is Knapsack Problem?**

Imagine you have:

* A **bag (knapsack)** with a **weight limit** (capacity).
* Several items, each with:

  * **Value** (profit)
  * **Weight**

Goal → Put items in the bag so the **total value is maximized** without exceeding weight capacity.

---

## 1️⃣ **Fractional Knapsack**

* **You can take fractions of an item** (cut items into smaller parts).
* **Approach:** Greedy — take items with **highest value/weight ratio** first.
* **Used in:** Problems where you can break items (e.g., gold dust, liquids).

**Example:**

```
Capacity = 50
Items: 
1 → weight = 10, value = 60
2 → weight = 20, value = 100
3 → weight = 30, value = 120
```

**Value/weight ratios:**

* Item1: 60/10 = 6
* Item2: 100/20 = 5
* Item3: 120/30 = 4

**Steps:**

* Take all of Item1 (weight 10, value 60)
* Take all of Item2 (weight 20, value 100)
* Take **fraction** of Item3 → need 20 weight left out of 30 → (20/30) \* 120 = 80 value

**Total value = 60 + 100 + 80 = 240**

**Key Points:**

* Fractions allowed ✅
* Greedy works (sort by value/weight ratio)
* Time complexity: **O(n log n)** (due to sorting)

---

## 2️⃣ **0/1 Knapsack**

* **You cannot take fractions** → either take the whole item or leave it.
* **Approach:** Dynamic Programming (Greedy doesn’t always work here).
* **Used in:** Problems where items are **indivisible** (e.g., laptop, book).

**Example:**

```
Capacity = 50
Items: 
1 → weight = 10, value = 60
2 → weight = 20, value = 100
3 → weight = 30, value = 120
```

We try all combinations (using DP) to find max value without exceeding 50 weight.

**Best selection:**

* Item2 (20, 100) + Item3 (30, 120) = total weight 50, total value 220

**Key Points:**

* Fractions ❌
* DP used to try all possibilities
* Time complexity: **O(n × capacity)**

---

## 3️⃣ **Unbounded Knapsack**

* **You can take unlimited copies** of each item.
* **Approach:** Dynamic Programming (similar to 0/1 but loop order changes).
* **Used in:** Problems like coin change, cutting rods, etc.

**Example:**

```
Capacity = 8
Items: 
1 → weight = 1, value = 15
2 → weight = 3, value = 50
3 → weight = 4, value = 60
```

You can take multiple copies:

* Take 2 copies of Item2 (3+3 weight, value 100) + 2 weight left → take Item1 twice (value 30)
* Total value = 130

**Key Points:**

* Fractions ❌
* Unlimited quantity of each item
* Time complexity: **O(n × capacity)**

---

## 📊 **Comparison Table**

| Feature            | Fractional Knapsack | 0/1 Knapsack        | Unbounded Knapsack  |
| ------------------ | ------------------- | ------------------- | ------------------- |
| Fractions allowed? | ✅ Yes               | ❌ No                | ❌ No                |
| Unlimited copies?  | ❌ No                | ❌ No                | ✅ Yes               |
| Best approach      | Greedy              | Dynamic Programming | Dynamic Programming |
| Time Complexity    | O(n log n)          | O(n × capacity)     | O(n × capacity)     |
| Example use        | Liquids, gold dust  | Books, gadgets      | Coins, rods         |


---

## **1. Fractional Knapsack**

**Idea:**

* You can take fractions of an item (like cutting gold into pieces).
* Choose items in decreasing **value/weight** ratio until the bag is full.
* **Greedy approach** is used (pick best value per weight first).

**Example:**

```
Capacity = 50
Items:  
Weight = 10, Value = 60  → ratio = 6  
Weight = 20, Value = 100 → ratio = 5  
Weight = 30, Value = 120 → ratio = 4  

Pick item1 (10kg) → 60 value  
Pick item2 (20kg) → 100 value  
Bag left = 20kg, take 20/30 of item3 = (20 * 4) = 80 value  
Total = 60 + 100 + 80 = 240
```

✅ Fraction allowed.

**Java Code:**

```java
import java.util.*;

class Item {
    int weight, value;
    Item(int w, int v) { weight = w; value = v; }
}

public class FractionalKnapsack {
    static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));
        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += ((double)item.value / item.weight) * capacity;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
        int capacity = 50;
        System.out.println("Max value: " + getMaxValue(items, capacity));
    }
}
```

---

## **2. 0-1 Knapsack**

**Idea:**

* You **cannot take fractions** of an item.
* Either take the whole item or skip it.
* **Dynamic Programming** is used.

**Example:**

```
Capacity = 50
Items:  
Weight = 10, Value = 60  
Weight = 20, Value = 100  
Weight = 30, Value = 120  

Best choice: item2 + item3 = weight 50, value 220  
(Fraction not allowed)
```

**Java Code (DP):**

```java
public class ZeroOneKnapsack {
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        System.out.println("Max value: " + knapSack(W, wt, val, val.length));
    }
}
```

---

## **3. Unbounded Knapsack**

**Idea:**

* You can take **unlimited quantities** of an item.
* Similar to 0-1 knapsack but you **don’t reduce the item count** when picked.

**Example:**

```
Capacity = 8
Items:  
Weight = 2, Value = 10  
Weight = 3, Value = 14  
Weight = 4, Value = 16  

Best choice: take four items of weight 2 → total value = 40  
```

**Java Code (DP):**

```java
public class UnboundedKnapsack {
    static int unboundedKnapsack(int W, int wt[], int val[], int n) {
        int[] dp = new int[W + 1];
        for (int w = 0; w <= W; w++) {
            for (int i = 0; i < n; i++) {
                if (wt[i] <= w) {
                    dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int val[] = {10, 14, 16};
        int wt[] = {2, 3, 4};
        int W = 8;
        System.out.println("Max value: " + unboundedKnapsack(W, wt, val, val.length));
    }
}
```

---

✅ **Key Differences Table:**

| Feature            | Fractional Knapsack | 0-1 Knapsack        | Unbounded Knapsack  |
| ------------------ | ------------------- | ------------------- | ------------------- |
| Fraction allowed   | ✅ Yes               | ❌ No                | ❌ No                |
| Unlimited quantity | ❌ No                | ❌ No                | ✅ Yes               |
| Approach           | Greedy              | Dynamic Programming | Dynamic Programming |
| Time Complexity    | O(n log n)          | O(n\*W)             | O(n\*W)             |

---

