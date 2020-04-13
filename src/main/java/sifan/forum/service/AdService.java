package sifan.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sifan.forum.mapper.AdMapper;
import sifan.forum.model.Ad;
import sifan.forum.model.AdExample;


import java.util.List;

@Service
public class AdService {
    @Autowired
    private AdMapper adMapper;

    public List<Ad> list(String pos) {
        AdExample navExample = new AdExample();
        navExample.createCriteria()
                .andStatusEqualTo(1)
                .andPosEqualTo(pos)
                .andGmtStaterLessThan(System.currentTimeMillis())
                .andGmtEndGreaterThan(System.currentTimeMillis());
        //       adExample.setOrderByClause("priority desc");
        return adMapper.selectByExample(navExample);
    }
}
