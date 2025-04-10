import {BrowserRouter, Link, Route, Routes} from 'react-router-dom'
import Main from './Main';
import PostList from './PostList';
import PostInsert from './PostInsert';
import Nav from './Nav';
import PostDetail from './PostDetail';

function App() {
  

  return (

    //a태그 대신 Link태그 이용. 링크 클릭해도 url은 바뀌는데 새로고침은 x
    //div 태그 대신 BrowserRouter
    <BrowserRouter>
      <Nav/>
      <Routes>
        <Route path='/' exact element={<Main/>} />
        <Route path='/post/list/:num' element={<PostList/>} />
        <Route path='/post/detail/:num' element={<PostDetail/>} />
        {/*<Route path='/post/insert' element={<PostInsert/>} />*/}
      </Routes>
    </BrowserRouter>
  );
}

export default App;


