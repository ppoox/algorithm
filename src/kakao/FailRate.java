package kakao;

public class FailRate {
//    ############################################################ 나의 풀이 (JAVA)
    public int[] solution(int N, int[] stages) {
        double[] failArr = new double[N];
        int[] indexes = new int[N];

        for(int i=0; i<stages.length; i++) {
            if(stages[i] != N+1) {
                failArr[stages[i]-1] = failArr[stages[i]-1] + 1;
            }
        }

        int members = stages.length;
        for(int i=0; i<N; i++) {
            indexes[i] = i+1;

            int stageMember = (int) failArr[i];
            failArr[i] = failArr[i]/members;

            members -= stageMember;
        }

        for(int i=0; i<failArr.length; i++) {
            for(int j=i; j<failArr.length; j++) {
                if(failArr[i] < failArr[j]) {
                    int tmpIndex = indexes[j];
                    indexes[j] = indexes[i];
                    indexes[i] = tmpIndex;

                    double tmp = failArr[j];
                    failArr[j] = failArr[i];
                    failArr[i] = tmp;
                }else if(failArr[i] == failArr[j] & indexes[i] > indexes[j]) {
                    int tmpIndex = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = tmpIndex;
                }
            }
        }

        return indexes;
    }
//
//
//############################################################ 다른사람 풀이 (Javascript)
//    function solution(N,stages) {
//        var answer = [],
//        result = [];
//
//        for(var i =0; i < N; i++) {
//            var a = stages.filter(word => word >= i+1).length;
//            var b = stages.filter(word => word == i+1).length;
//
//            b === 0 ? result.push(0) : a === 0 ? result.push(1) : result.push(b/a);
//        }
//
//        for(var i =0; i < N; i++) {
//            var index = result.indexOf(Math.max.apply(null, result));
//            answer.push(index+1);
//            result[index] = -1;
//        }
//
//
//        return answer;
//    }
//
//############################################################ 다른사람 풀이 (Javascript)
//    function solution(N, stages) {
//        let ans = []
//
//        for (let i = 1; i <= N; ++i) {
//            let usersReachedCurrentStage   = stages.reduce((acc, curStage) => acc + ((curStage >= i) ? 1 : 0), 0)
//            let usersStagnatedCurrentStage = stages.reduce((acc, curStage) => acc + ((curStage == i) ? 1 : 0), 0)
//            if (usersReachedCurrentStage === 0) {
//                ans.push({ 'stage': i, 'failRate': 0 })
//                continue
//            }
//
//            ans.push({ 'stage': i, 'failRate': (usersStagnatedCurrentStage / usersReachedCurrentStage) })
//        }
//
//        return ans.sort((a, b) => {
//            if (a.failRate > b.failRate) return -1
//            if (a.failRate < b.failRate) return 1
//            return a.stage - b.stage
//        }).map(entry => entry.stage)
//    }
//
//
//############################################################ 다른사람 풀이 (Python)
//    def solution(N, stages):
//    result = {}
//    denominator = len(stages)
//    for stage in range(1, N+1):
//            if denominator != 0:
//    count = stages.count(stage)
//    result[stage] = count / denominator
//    denominator -= count
//        else:
//    result[stage] = 0
//            return sorted(result, key=lambda x : result[x], reverse=True)
}
