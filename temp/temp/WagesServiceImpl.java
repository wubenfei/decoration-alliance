package temp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import temp.temp.Wages;
import com.ours.staff.mapper.WagesMapper;
import com.ours.staff.service.WagesService;
@Service
public class WagesServiceImpl implements WagesService{

    @Resource
    private WagesMapper wagesMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return wagesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Wages record) {
        return wagesMapper.insert(record);
    }

    @Override
    public int insertSelective(Wages record) {
        return wagesMapper.insertSelective(record);
    }

    @Override
    public Wages selectByPrimaryKey(Integer id) {
        return wagesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Wages record) {
        return wagesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Wages record) {
        return wagesMapper.updateByPrimaryKey(record);
    }

}
