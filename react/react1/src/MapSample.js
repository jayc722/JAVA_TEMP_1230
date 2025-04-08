
/* 


*/


function MapSample() {
	let titles = ["아침","점심","저녁","간식"];	// 이 타이틀들을 ul 태그 안의 li태그로 추가해주려고


	return (
		<div>
			<ul>
				{
					titles.map((v, i , arr)=>{
						return <li key={i}>{v}</li>
					})
				}
			</ul>
		</div>

	);
}

export default MapSample;