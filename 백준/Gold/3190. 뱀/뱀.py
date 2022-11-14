from collections import deque

N = int(input())
K = int(input())

dy = [1, 0, -1, 0]
dx = [0, -1, 0, 1]
flag = 0
snake = deque()

path = [[0] * N for i in range(N)]

for i in range(K):
    x, y = map(int, input().split())
    path[x - 1][y - 1] = 1

L = int(input())
direction = deque()
for i in range(L):
    t, d = input().split()
    t = int(t)
    direction.append([t, d])

x, y = 0, 0
snake.append([x, y])
game_time = 0

finish = False
while True:
    if len(direction) != 0 and direction[0][0] == game_time:
        order = direction.popleft()
        if order[1] == "D":
            flag -= 1
            if flag == -1 :
                flag = 3
        else :
            flag = (flag + 1) % 4

    game_time += 1

    x += dx[flag]
    y += dy[flag]

    if not(0 <= x < N and 0 <= y < N):
        break
    for body in snake:
        if body[0] == x and body[1] == y:
            finish = True
            break

    if finish:
        break

    snake.append([x, y])

    if path[x][y] == 1:
        path[x][y] = 0
    else:
        snake.popleft()






print(game_time)
