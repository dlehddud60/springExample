package kr.bit.service;


import kr.bit.entity.Board;
import kr.bit.entity.Member;

import java.util.List;

public interface BoardService {

    public List<Board> getList();
    public Member login(Member vo);
    public void register(Board vo);
    public Board get(int idx);
    public void modify(Board vo);
    public void remove(int idx);
    public void replyProcess(Board vo);

}
