import { use, useEffect, useState } from 'react';

function App() {
  let [num, setNum] = useState(0);//렌더링 실행될 때마다 app실행이 다시 실행됨
  //렌더링 될때마다 다시 받아와야 하니 오래 걸림 -> 이때 쓰는게 useEffect함수
  
  let [num2, setNum2] = useState(0);

  useEffect(()=>{
    console.log("처음 렌더링할 때만 실행");
    
  }, []);   //[]이면 처음 렌더링떄만 실행

  
  useEffect(()=>{
    console.log("num가 바뀔 때만 실행");
    
  }, [num]);   //[num]이면 num이 바뀌고 렌더링 될때만 실행됨

  return (
    <div>
      <button onClick={(e)=>setNum(++num)}>+</button>
      <div>{num}</div>

      <button onClick={(e)=>setNum2(++num2)}>+</button>
      <div>{num2}</div>
    </div>
  );
}

export default App;
