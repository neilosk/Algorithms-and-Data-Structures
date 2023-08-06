
    public class DHonts implements Comparable<DHonts> {

        protected int party;
        private int votes;
        protected int seats;

        public DHonts(int party, int votes) {
            this.party = party;
            this.votes = votes;
            this.seats = 0;
            
        }

        //Compare two DHonts objects based on the quotient of votes and seats
        //The quotient is calculated as votes / (1 + seats)
        //The DHonts object with the larger quotient is considered larger than the other
        @Override
        public int compareTo(DHonts that) {
            Double thisQuotient = (double) this.votes / (1 + this.seats);
            Double thatQuotient = (double) that.votes / (1 + that.seats);
            return thisQuotient.compareTo(thatQuotient);
        }
    }

