#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

int flag[2] = {0, 0};
int turn;
int shared = 0;

void *process0(void *arg) {
    for(int i = 0; i < 5; i++) {
        flag[0] = 1;
        turn = 1;
        while(flag[1] && turn == 1);

        // Critical Section
        shared+=2;
        printf("Process 0: shared = %d\n", shared);

        flag[0] = 0;

        // Remainder Section
        sleep(1);
    }
    return NULL;
}

void *process1(void *arg) {
    for(int i = 0; i < 5; i++) {
        flag[1] = 1;
        turn = 0;
        while(flag[0] && turn == 0);

        // Critical Section
        shared--;
        printf("Process 1: shared = %d\n", shared);

        flag[1] = 0;

        // Remainder Section
        sleep(1);
    }
    return NULL;
}

int main() {
    pthread_t t1, t2;

    pthread_create(&t1, NULL, process0, NULL);
    pthread_create(&t2, NULL, process1, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    return 0;
}