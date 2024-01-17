class Solution {
    int newCount = 0;
    boolean found = false;
    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean[] visited = new boolean[bank.length];
        Queue<String> genes = new LinkedList<>();
        genes.offer(startGene);
        int mutations = 0;
        int count = 1;
        while(!genes.isEmpty()){
            newCount = 0;
            while(count>0){
                String gene = genes.poll();
                if(gene.equals(endGene)) return mutations;
                explore(gene, bank, genes, visited, endGene);
                count--;
            }
            count = newCount;
            mutations++;
            if(found) return mutations;
        }
        return -1;
    }
    void explore(String gene, String [] bank, Queue<String> genes, boolean[]visited, String endGene){
        for(int i = 0;i<bank.length;i++){
            if(!visited[i]){
                int count = 0;
                for(int j = 0;j<gene.length();j++){
                    if(gene.charAt(j) != bank[i].charAt(j)){
                        count++;
                        if(count>1)break;
                    }
                }
                if(count == 1){
                    if(bank[i].equals(endGene)) found = true;
                    genes.offer(bank[i]);
                    visited[i]=true;
                    newCount++;
                }
            }
        }
    }
}