package cn.dm.service;

import cn.dm.pojo.DmItemType;
import cn.dm.vo.DmFloorItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.dm.mapper.DmItemMapper;
import cn.dm.pojo.DmItem;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zezhong.shang on 18-5-15.
 */
@RestController
public class RestDmItemService {

    @Autowired
    private DmItemMapper dmItemMapper;

    @RequestMapping(value = "/getDmItemById", method = RequestMethod.POST)
    public DmItem getDmItemById(@RequestParam("id") Long id) throws Exception {
        return dmItemMapper.getDmItemById(id);
    }

    @RequestMapping(value = "/getDmItemListByMap", method = RequestMethod.POST)
    public List<DmItem> getDmItemListByMap(@RequestBody Map<String, Object> param) throws Exception {
        return dmItemMapper.getDmItemListByMap(param);
    }

    @RequestMapping(value = "/getHotDmItemList", method = RequestMethod.POST)
    public List<DmItem> queryItemHot(@RequestBody Map<String, Object> param) throws Exception {
        return dmItemMapper.getHotDmItemList(param);
    }

    @RequestMapping(value = "/getDmItemCountByMap", method = RequestMethod.POST)
    public Integer getDmItemCountByMap(@RequestParam Map<String, Object> param) throws Exception {
        return dmItemMapper.getDmItemCountByMap(param);
    }

    @RequestMapping(value = "/qdtxAddDmItem", method = RequestMethod.POST)
    public Integer qdtxAddDmItem(@RequestBody DmItem dmItem) throws Exception {
        dmItem.setCreatedTime(new Date());
        return dmItemMapper.insertDmItem(dmItem);
    }

    @RequestMapping(value = "/qdtxModifyDmItem", method = RequestMethod.POST)
    public Integer qdtxModifyDmItem(@RequestBody DmItem dmItem) throws Exception {
        dmItem.setUpdatedTime(new Date());
        return dmItemMapper.updateDmItem(dmItem);
    }

    @RequestMapping(value = "/queryItemByFloor", method = RequestMethod.POST)
    public List<DmFloorItems> queryItemByFloor() throws Exception {
        return dmItemMapper.queryItemByFloor();
    }

    @RequestMapping(value = "/queryItemByMonth", method = RequestMethod.POST)
    public List<DmItem> queryItemByMonth(@RequestParam("month") Integer month,
                                         @RequestParam("year") Integer year) throws Exception {
        return dmItemMapper.getItemByMonth(month, year);
    }
}
