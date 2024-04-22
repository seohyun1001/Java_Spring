package org.zerock.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO <E>{

    private int page;
    private int size;
    private int total;

    // 시작 페이지 번호
    private int start;
    // 끝 페이지 번호
    private int end;

    // 이전 페이지의 존재 여부
    private boolean prev;
    // 다음 페이지의 존재 여부
    private boolean next;

    private List<E> dtoList;



    // 생성자 만들기
    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        // end 페이지 먼저 계산하기
        // 예) 1페이지를 10으로 나누면 0.1이 됨
        // -> 0.1을 올림을 하면 1이 되고
        // -> *10을 하면 끝 페이지가 10이 됨
        // 예) 11페이지 / 10 = 1.1 -> 올림 = 2 * 10 = 20
        // 예) 2페이지 / 10 = 0.2 -> 올림 = 1 * 10 = 10
        // 예) 21페이지 / 10 = 2.1 -> 올림 = 3 * 10 = 30

        // 딱 안 떨어지는 경우
        // 예) 게시글 총 : 75개로 가정
        // 75 / 10 = 7.5 -> 8페이지
        // 예2) 현재 페이지에서 끝 페이지가 고정으로 10으로 나옴 -> 문제가 됨
        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;


        // start 페이지 계산하기
        // 예) end = 30, start = 30 - 9 = 21
        // 예) end = 20, start = 20 - 9 = 11
        this.start = this.end - 9;

        // last 값이 없어서 생성후 end 멤버에 재사용하기
        // 예) 게시글 총 : 75개로 가정
        // 75 / 10 = 7.5 -> 8페이지
        int last = (int)(Math.ceil((total/(double)size)));

        // 결론
        // 예) end>last -> last
        // 예) 10 > 8 -> 8
        this.end = end > last ? last : end;

        // prev : 이전 페이지 존재 유무
        this.prev = this.start > 1;

        // next : 다음 페이지 존재 유무
        // 예) 총 게시글 : 75개 가정
        // -> end = 8 / size = 10(고정)
        // 75 > 80 -> 거짓(false)

        // 예) 총 게시글 : 103개
        // total / 10 = 10.3 -> 올림 = 11
        // end = 10(기본)
        // 10 > 11 = false -> end(11로 변경)
        // 103 > 110 = false
        this.next = total > this.end * this.size;
    }




}
