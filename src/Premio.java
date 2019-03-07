public class Premio {
        private Fruta[] CombGanad;
        private int premio;
        
        public Fruta[] getCombGanad() {
                return CombGanad;
        }
 
        public int getPremio() {
                return premio;
        }
 
        // CONSTRUCTORES
        public Premio(Fruta[] combinacion, int p) {
                CombGanad=combinacion;
                premio=p;
        }
}

