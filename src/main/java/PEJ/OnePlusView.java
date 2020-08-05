package PEJ;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="OnePlusView_table")
public class OnePlusView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String prdId;
        private String prdAttrCd;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getPrdId() {
            return prdId;
        }

        public void setPrdId(String prdId) {
            this.prdId = prdId;
        }
        public String getPrdAttrCd() {
            return prdAttrCd;
        }

        public void setPrdAttrCd(String prdAttrCd) {
            this.prdAttrCd = prdAttrCd;
        }

}
