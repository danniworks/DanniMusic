package entity;

import service.subject.MusicPlayer;

public enum MusicState {
    Play {
        @Override
        public void execute(MusicPlayer musicPlayer) {
            musicPlayer.setState(MusicState.Play);
        }
    },
    Pause {
        @Override
        public void execute(MusicPlayer musicPlayer) {
            musicPlayer.setState(MusicState.Pause);
        }
    },
    Skip {
        @Override
        public void execute(MusicPlayer musicPlayer) {
            musicPlayer.setState(MusicState.Skip);
        }
    },
    Resume {
        @Override
        public void execute(MusicPlayer musicPlayer) {
            musicPlayer.setState(MusicState.Resume);
        }
    },
    Loading {
        @Override
        public void execute(MusicPlayer musicPlayer) {
            musicPlayer.setState(MusicState.Loading);
        }
    };

    public abstract void execute(MusicPlayer musicPlayer);
}
