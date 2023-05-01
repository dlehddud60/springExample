package kr.bit.service;


import kr.bit.entity.Board;
import kr.bit.entity.Member;

import java.util.List;

public interface BoardService {

    public List<Board> getList();
    public Member login(Member vo);
    public void register(Board vo);


}
