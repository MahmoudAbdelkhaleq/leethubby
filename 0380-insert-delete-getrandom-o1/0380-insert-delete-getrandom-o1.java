class RandomizedSet {
    Set <Integer> set;
    Iterator<Integer> iterator;
    public RandomizedSet() {
        set = new HashSet<>();
        iterator = set.iterator();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)) return false;
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val)) return false;
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        int size = set.size();
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < randomIndex; i++) {
            iterator.next();
        }
        return iterator.next();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */