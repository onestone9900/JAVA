# Maven Setting
 - groupId  
    - 모든 프로젝트 사이에서 고유하게 식별해주는 ID  
    - package 명명 규칙을 따름
    - 보통 자신의 도메인 이름 역순으로 생성 
       - 예) com.owen.www
    - 다중 모듈 프로젝트 시 root 프로젝트의 현재 프로젝트의 식별자를 추가
       - 예) root 프로젝트 groupId : com.owen.root
       - 예) root 프로젝트의 하위 모듈 groupId  : com.owen.root.core , com.owen.root.batch, com.owen.root.www
 - artifactId  
    - 버전 정보를 생략한 jar 파일의 이름  