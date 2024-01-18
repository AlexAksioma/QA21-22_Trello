package dataproviders;

import models.BoardDTO;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderBoard {

    @DataProvider
    public Iterator<Object[]> dataProvider_createNewBoardPositiveTest_DP(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{BoardDTO.builder().boardTitle("dataProvider1").build()});
        list.add(new Object[]{BoardDTO.builder().boardTitle("dataProvider2").build()});
        list.add(new Object[]{BoardDTO.builder().boardTitle("dataProvider3").build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProvider_deleteBoardPositiveTest_DP() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_delete1").build()});
        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_delete2").build()});
        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_delete3").build()});
        return list.iterator();
    }
}
