package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{
    //@Autowired
    //@Qualifier("dao")
    private IDao dao;

    public MetierImpl(IDao dao){
        this.dao=dao;
    }

    @Override
    public double calcul() {
        double temp = dao.getData();
        double r = temp *40/3;
        return r;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
