import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class TestElection{
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of candidates"));
        Election[] elections = new Election[n];

        float totalNumVotes = 0; //This is the total number of votes
        int winnerIndex = 0; //Tracks winner's index
        int votes; //currect candidate's votes
        int max_votes = 0;//highest number of votes
        String candidateInput;
        String nVoteInput;
        for(int i = 0; i < n; i++){
            candidateInput = JOptionPane.showInputDialog(null, "Enter candidate " + Integer.toString(i+1) + "'s name");
            nVoteInput = JOptionPane.showInputDialog(null, "Enter candidate " + Integer.toString(i+1) + "'s number of votes");
            votes = Integer.parseInt(nVoteInput);
            elections[i] = new Election(candidateInput, votes );

            //Helper values fo the table
            totalNumVotes += votes;
            if(votes > max_votes){
                max_votes = votes;
                winnerIndex = i;
            }else{
                continue;
            }
        }
        
        //The table
        System.out.printf("%-15s%-15s%-15s%n","Candidate","Votes   ", "% of Total Votes");
        for(int i = 0; i <n; i++){
            candidateInput =  elections[i].getCandidate();
            nVoteInput = elections[i].toString();
            System.out.printf( "%-15s%-15s%-15s%n", candidateInput, nVoteInput, String.format("%.2f", 100*Float.valueOf(elections[i].toString())/totalNumVotes));
            // -15s means allowing a string of 15 char aligned left
            // -15d means allowing an integer of 15 char aligned left
        }
        System.out.println("\nTotal Votes: " + Integer.toString((int) totalNumVotes) + "\nThe Winner is: " + elections[winnerIndex].getCandidate());
        
        //table done!
        List<String> chosenOnes = new ArrayList<>();//Stores names with more than 3999 votes
        StringBuilder message = new StringBuilder();//Will be used to display names using Pane
        for(int i = 0; i < n; i++){
            votes = elections[i].getNumVotes(); // reuse the integer variable
            candidateInput = elections[i].getCandidate(); //Reuse the string variable
            if( votes > 4000){
                chosenOnes.add(candidateInput);
                message.append(candidateInput + ", ");
            }
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Candidates with over 3999 votes", JOptionPane.INFORMATION_MESSAGE);
    }
}