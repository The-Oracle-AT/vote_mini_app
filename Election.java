public class Election {
    private String candidate;
    private int nVotes;
     public Election(String candidate, int nVotes ){
        this.candidate = candidate;
        this.nVotes = nVotes;
     }
     public void setCandidate(String candidate){
        this.candidate = candidate;
     }
     public String getCandidate(){
        return this.candidate;
     }
     public void setNumVotes(int nVotes){
        this.nVotes = nVotes;
     }
    public int getNumVotes(){
        return this.nVotes;
    }
     public String toString() {
        return Integer.toString(this.getNumVotes());
     }
}
