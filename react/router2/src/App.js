import {BrowserRouter, Link, Route, Routes} from 'react-router-dom';
import PostList from './PostList';
import Main from './Main';
import PostInsert from './PostInsert';





function App() {
  return(
    
    //a태그 대신 Link태그 이용. 링크 클릭해도 url은 바뀌는데 새로고침은 x
    //div 태그 대신 BrowserRouter
    <BrowserRouter>
      <nav>
        <ul>
          <li>
            <Link to={"/"}>메인</Link>
          </li>
          <li>
            <Link to={"/post/list"}>게시글 목록</Link>
          </li>
          <li>
            <Link to={"/post/insert"}>게시글 등록</Link>
          </li>
        </ul>
      </nav>
      <Routes>
        <Route path='/' exact element={<Main/>} />
        <Route path='/post/list/:num' element={<PostList/>} />
        <Route path='/post/insert' element={<PostInsert/>} />

      </Routes>

    </BrowserRouter>
    
  );
}

export default App;
