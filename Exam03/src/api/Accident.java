package api;

public class Accident {



 // 포스트맨 통해서 보면 타입이 먼지도 알 수 있음... 깔아보기
 
        private String occrrncDt;  // 발생월일시 (2019011622)

        private String occrrncDayCd;  // 발생요일코드 (4)

        private int dthDnvCnt;  // 사망자수 (0)

        private int injpsnCnt;  // 부상자수 (1)
        

		public String getOccrrncDt() {
			return occrrncDt;
		}

		public void setOccrrncDt(String occrrncDt) {
			this.occrrncDt = occrrncDt;
		}

		public String getOccrrncDayCd() {
			return occrrncDayCd;
		}

		public void setOccrrncDayCd(String occrrncDayCd) {
			this.occrrncDayCd = occrrncDayCd;
		}

		public int getDthDnvCnt() {
			return dthDnvCnt;
		}

		public void setDthDnvCnt(int dthDnvCnt) {
			this.dthDnvCnt = dthDnvCnt;
		}

		public int getInjpsnCnt() {
			return injpsnCnt;
		}

		public void setInjpsnCnt(int injpsnCnt) {
			this.injpsnCnt = injpsnCnt;
		}
      
 
 
	
	
	
	
}